<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.MemberDto"%>
<%@ page import="member.MemberDao"%>
<%@ page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<%
	String check1 = null;
	String check2 = null;

	if(request.getParameter("check1") != null){
		check1 = request.getParameter("check1");
	}
	
	if(request.getParameter("check2") != null){
		check2 = request.getParameter("check2");
	}
	
	if(check1 == null || check2 == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('전체동의 하셔야합니다.!');");
		script.println("history.back();");
		script.println("</script>");
		return;
	} else {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href = 'joinMain.jsp';");
		script.println("</script>");
		return;
	}
	

		 
%>