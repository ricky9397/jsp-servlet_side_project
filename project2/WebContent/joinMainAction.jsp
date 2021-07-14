<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.MemberDto"%>
<%@ page import="member.MemberDao"%>
<%@ page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	MemberDao dao = MemberDao.getInstance();
	String id = null;
	String pw = null;
	String name = null;
	String address = null;
	String phoneNum = null;
	String email = null;
	
	
	if(request.getParameter("id") != null){
		id = request.getParameter("id");
	}
	if(request.getParameter("pw") != null){
		pw = request.getParameter("pw");
	}
	if(request.getParameter("name") != null){
		name = request.getParameter("name");
	}
	if(request.getParameter("address") != null){
		address = request.getParameter("address");
	}
	if(request.getParameter("phone") != null){
		phoneNum = request.getParameter("phoneNum");
	}
	if(request.getParameter("email") != null){
		email = request.getParameter("email");
	}
	
	if(id == null || pw == null || name == null || address == null || phoneNum == null || email == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안된 사항이 있습니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}
	
	int result = dao.join(new MemberDto(id, pw, name, address, phoneNum, email));
	
	if(result == 1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('회원가입에 성공했습니다.');");
		script.println("location.href = 'index.jsp';");
		script.println("</script>");
		script.close();
		return;
	}
	
	if(result == -1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 존재하는 아이디입니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	} else {
		session.setAttribute("id", id);
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href = 'index.jsp';");
		script.println("</script>");
		script.close();
		return;
	}
%>