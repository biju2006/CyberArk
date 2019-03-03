package aaa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SayHello implements Command {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("user");
		System.out.println("Hello "+name);
	}

}
