package sx.ex.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller
{
	protected final Log logger=LogFactory.getLog(getClass());
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		logger.info("returning the hello view");
		String now=(new Date()).toString();
		logger.info("returning hello view with "+now);
		return new ModelAndView("WEB-INF/jsp/hello.jsp","now",now);
	}
}
