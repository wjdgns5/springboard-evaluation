<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 페이지</title>
</head>
<body>

<p>Board.jsp 페이지 진입</p>

<form action="/blog/bupdateProc/${board.number}" method="post"> 
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" maxlength="20" class="form-control" placeholder="Enter 제목" id="title" name="title" value="${board.title}">
			<input type="hidden" maxlength="20" class="form-control" id="id" name="number" value="${board.number}">
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<input type="text"  maxlength="20" class="form-control" placeholder="Enter 내용" id="content" name="content" value="${board.content}">
		</div>
		<div class="form-group">
			<label for="author">작성자</label>
			<input type=text  maxlength="10" class="form-control" placeholder="Enter 작성자" id="author" name="author" value="${board.author}">
		</div>		
		
		<div class="text-right">
			<button type="submit" class="btn btn-primary">수정하기</button>
		</div>
		
	</form>

</body>
</html>