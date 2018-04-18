package by.htp.library.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BaseAction {

	void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
