package aaa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sum implements Command {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) {
		int x=Integer.parseInt(request.getParameter("num1"));
		int y=Integer.parseInt(request.getParameter("num2"));
		System.out.println(x+y);
	}

}
