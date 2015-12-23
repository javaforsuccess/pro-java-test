package com.pratap.ex.jms.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import javax.sql.DataSource;

import oracle.jms.AQjmsFactory;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MyJmsEnv 
{
	private static MyJmsEnv mjenv = new MyJmsEnv();
	private DataSource dataSource = null;
	private Connection connection = null;
	private MyDbFactory myDbFactory = null;

	private MyJmsEnv() 
	{
		this.myDbFactory = new MyDbFactory();
		try {
			this.myDbFactory.createOracleDataSource("jdbc:oracle:thin:@localhost:1521:XE", "system", "root");
			this.dataSource = myDbFactory.getOracleDataSource();
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static MyJmsEnv getMyJmsEnv(){
		return mjenv;
	}
	
	public void jmsEnvSetup(String queueAndTableName){
		//create random unique table name
		String priorityQueueAndTableName = queueAndTableName;//RandomStringUtils.random( 16, true, true );
		//System.out.println("-----> priorityQueueAndTableName : [ "+ priorityQueueAndTableName +" ]");

		
		try {
			//Create a queue table
			connection.prepareCall("{call dbms_aqadm.create_queue_table ( queue_table => '"+ priorityQueueAndTableName +"', sort_list => 'PRIORITY,ENQ_TIME', queue_payload_type => 'sys.aq$_jms_map_message', compatible => '8.1.0')}").execute();
			
			//create a queue
			connection.prepareCall("{call dbms_aqadm.create_queue ( queue_name => '"+ priorityQueueAndTableName +"', queue_table => '"+ priorityQueueAndTableName +"')}").execute();

			//Start the queue
			connection.prepareCall("{call dbms_aqadm.start_queue (queue_name => '"+ priorityQueueAndTableName +"')}").execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void jmsEnvDest(String queueAndTableName){
		String priorityQueueAndTableName = queueAndTableName;
		try {
			connection.prepareCall("{call dbms_aqadm.stop_queue(queue_name => '"+ priorityQueueAndTableName +"')}").execute();
			connection.prepareCall("{call DBMS_AQADM.DROP_QUEUE(queue_name => '"+ priorityQueueAndTableName +"')}").execute();
			connection.prepareCall("{call DBMS_AQADM.DROP_QUEUE_TABLE(queue_table => '"+ priorityQueueAndTableName +"')}").execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMessage(String queueAndTableName, final String msgId, final int msgPriority, final String queueName, String msgBody){
		try{

			
			ConnectionFactory connectionFactory = null;
			try {
				connectionFactory = AQjmsFactory.getQueueConnectionFactory(dataSource);
			} catch (JMSException e) {
				e.printStackTrace();
			}
			JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
			jmsTemplate.setExplicitQosEnabled(true);
			MessageCreator messageCreator = new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					MapMessage message = session.createMapMessage();
					// ... set some properties
					message.setJMSMessageID(msgId);
					message.setString("queueName", queueName);
					message.setJMSPriority(msgPriority);
					return message;
				}
			};
			jmsTemplate.setPriority(msgPriority);
			jmsTemplate.setDefaultDestinationName(queueAndTableName);
			jmsTemplate.setConnectionFactory(connectionFactory);
			jmsTemplate.send(queueAndTableName, messageCreator);


		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
