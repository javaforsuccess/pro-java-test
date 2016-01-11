package sx.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WelcomeController implements Controller
{
	protected final Log logger=LogFactory.getLog(getClass());
	private String viewName;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception 
	{
		logger.info("returning the welcome page.");
		viewName="welcome-page";
		return new ModelAndView(viewName,"model",null);
	}

}
