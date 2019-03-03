package aaa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

	public void handle(HttpServletRequest request, HttpServletResponse response);
}
