<jsp:directive.page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.outer{
		width:800px;
		height:500px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	td {
		border:1px solid white;
	}

	.tableArea {
		border:1px solid white;
		width:800px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
	}
	#content {
		height:230px;
	}
	.replyArea {
		width:800px;
		/* height:300px; */
		color:white;
		background:black;
		margin-left:auto;
		margin-right:auto;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="outer">
		<br>
		<h2 align="center">게시판 내용</h2>
		<form action="${ pageContext.servletContext.contextPath }/board/update" method="post">
			<div class="tableArea">
					<table align="center" width="800px">
						<tr>
							<td>글번호</td>
							<td><c:out value="${ requestScope.board.no }"/></td>
							<td>분야 </td>
							<td>
							<select name="category">
								<option value="10" ${ requestScope.board.categoryCode eq "10"? "selected": "" }>공통</option>
								<option value="20" ${ requestScope.board.categoryCode eq "20"? "selected": "" }>운동</option>
								<option value="30" ${ requestScope.board.categoryCode eq "30"? "selected": "" }>등산</option>
								<option value="40" ${ requestScope.board.categoryCode eq "40"? "selected": "" }>게임</option>
								<option value="50" ${ requestScope.board.categoryCode eq "50"? "selected": "" }>낚시</option>
								<option value="60" ${ requestScope.board.categoryCode eq "60"? "selected": "" }>요리</option>
								<option value="70" ${ requestScope.board.categoryCode eq "70"? "selected": "" }>기타</option>
							</select>
							</td>
							<td>제목 </td>
							<td><input type="text" name="title" value="${ requestScope.board.title }"></td>
						</tr>
						<tr>
							<td>작성자 </td>
							<td><span><c:out value="${ requestScope.board.writer.nickname }"/></span></td>
							<td>조회수 </td>
							<td><span><c:out value="${ requestScope.board.count }"/></span></td>
							<td>작성일</td>
							<td><span><c:out value="${ requestScope.board.createdDate }"/></span></td>
						</tr>
						<tr>
							<td colspan="6">내용 </td>
						</tr>
						<tr >
							<td colspan="6">
								<textarea style="resize: none; width:100%" name="content" id="content"cols="">${ requestScope.board.body }</textarea>
<%-- 								<input type="textArea"  width="100%" name="content" id="content" value="${ requestScope.board.body }"> --%>
							</td>
						</tr>
					</table>
					<br>
			</div>
		<div align="center">
			<input type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/board/list'" value="메뉴로 돌아가기">
			<button type="submit">저장하기</button>
			<input type="hidden" name="no" value="${ requestScope.board.no }">
		</div>
		</form>
	</div>
</body>
</html>