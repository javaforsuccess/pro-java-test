<%@include file="/WEB-INF/jsp/include.jsp"%>
<center>
<form action="order.action">
	<table>
		<tr>
			<td>Your Name :</td>
			<td><input type="text" name="customerName"></td>
		</tr>
		<tr>
			<td>Pizza Type :</td>
			<td>
				<select name="type">
					<option value="small">SMALL</option>
					<option value="medium">MEDIUM</option>
					<option value="large">LARGE</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Number Of Items :</td>
			<td>
				<% 
					for(int i=1;i<=20;i++)
					{
				%>
						<input type="radio" name="noOfItems" value="<%=i %>" checked><%=i %>&nbsp&nbsp:&nbsp&nbsp
			
				<%
						if(i<=5){
							%>No Offer.<% 
						}
						else if(i<=10){
							%>2*New Offers.<% 
						}
						else if(i<=15){
							%>4*New Offers.<% 
						}
						else if(i<=20){
							%>7*New Offers.<% 
						}
						%><br><% 
						
					}
				%>
			</td>
		</tr>
		<tr>
			<td><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>
</center>