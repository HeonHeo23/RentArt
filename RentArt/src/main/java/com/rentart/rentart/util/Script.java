package com.rentart.rentart.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	public static int back(HttpServletResponse response, String msg) throws IOException {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('"+ msg +"');");
		script.println("history.go(-1);");
		script.println("</script>");
		script.flush();
		return 0;
	}
	
	public static int close(HttpServletResponse response, String msg) throws IOException {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('"+ msg +"');");
		script.println("window.close();");
		script.println("</script>");
		script.flush();
		return 0;
	}
}
