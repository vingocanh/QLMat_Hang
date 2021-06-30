<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<div class = "pages" style="display: flex; align-items: center; justify-content: center;">
		<div>
			<h1 style="text-align: center;">Quan ly mh</h1>
		        <h2>
		        	<a href="create">Them mh</a>   	            	
		        </h2>       
		        <table border="1" >
				<caption> List of chuyen bay</caption>
				<tr> 
					<th> Ten</th>
					<th>Mo ta</th>
					<th> chat lieu</th>
					<th> noi sx</th>
					<th> hang sx</th>
					<th> ngay sx</th>
					
				</tr>
				<c:forEach var="mh" items="${matHang}" >
					<tr>
						<th><c:out value="${mh.tenMH}"></c:out> </th>
						<th><c:out value="${mh.moTa}"></c:out> </th>
						<th><c:out value="${mh.chatLieu}"></c:out> </th>
						<th><c:out value="${mh.noiSX}"></c:out> </th>
						<th><c:out value="${mh.hangSX}"></c:out> </th>
						<th><c:out value="${mh.ngaySX}"></c:out> </th>
						
						<th>
							<a href="edit?maSV=<c:out value="${mh.id}"/>">Edit</a>
							<a href="delete?maSV=<c:out value="${mh.id}"/>">Delete</a>
						</th>
						
					</tr>
				 </c:forEach>
				</table>
		</div>
	</div>
</body>
</html>