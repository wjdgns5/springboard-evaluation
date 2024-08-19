<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        padding: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 8px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    tr:hover {
        background-color: #f1f1f1;
    }
    a {
        text-decoration: none;
        color: #007BFF;
    }
    a:hover {
        text-decoration: underline;
    }
</style>

</head>
<body>
<p><a href="/blog/board">글쓰기</a> </p>

	<div>
		<c:if test="${board == null}">
			<p>게시글이 없습니다.</p>
		</c:if>
		
		<c:if test="${board != null}">
		
			 <table border="1">
			 <tr>
				 <th>번호</th>
				 <th>제목</th>
				 <th>내용</th>
				 <th>작성자</th>
			 </tr>
			 
			 <c:forEach var="board" items="${board}">
			 <tr>
			 	<td>${board.number}</td>
			 	<td>${board.title}</td>
			 	<td>${board.content}</td>
			 	<td>${board.author}</td>
			 	<td><a href="/blog/delete/${board.number}">삭제</a></td>
			 	<td><a href="/blog/update/${board.number}">수정</a></td>
			 </tr>
        	</c:forEach>
        	
			 </table>
        	
		</c:if>
	</div>

</body>
</html>