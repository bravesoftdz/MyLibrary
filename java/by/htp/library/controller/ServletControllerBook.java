package by.htp.library.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.action.BaseAction;
import by.htp.library.action.manager.ActionManagerBook;
import by.htp.library.constants.ResponseSetting;
import by.htp.library.constants.ServletControllerSettings;
import by.htp.library.constants.ServletParameters;

@WebServlet("/ServletControllerBook")
public class ServletControllerBook extends HttpServlet implements Filter {
	private static final long serialVersionUID = 1L;
	private String encoding;

	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		synchronized (this) {
			String contentType = request.getContentType();
			if (contentType != null && contentType.startsWith(ServletControllerSettings.FILTERABLE_CONTENT_TYPE))
				request.setCharacterEncoding(encoding);
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter(ServletControllerSettings.ENCODING_INIT_PARAM_NAME);
		if (encoding == null)
			encoding = ServletControllerSettings.ENCODING_DEFAULT;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(ResponseSetting.CONTENT_TYPE_HTML);
		response.addHeader(ResponseSetting.ACCESS_HEADER, ResponseSetting.ACCESS_HEADER_TRUE);
		String userAction = request.getParameter(ServletParameters.PARAM_VALUE_ACTTION);
		String value = userAction;
		
		System.out.println(value);
		
		BaseAction action = ActionManagerBook.defineAction(value);
		action.doHttpReqRes(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		synchronized (this) {
			doGet(request, response);
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		synchronized (this) {
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		synchronized (this) {
		}
	}

}
