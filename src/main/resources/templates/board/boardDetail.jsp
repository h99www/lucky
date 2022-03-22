<jsp:directive.page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
		
		
		<div align="center">
		<h2 align="center">게시판 내용</h2>
			<button onclick="location.href='${ pageContext.servletContext.contextPath }/board/list'">메뉴로 돌아가기</button>
			<!-- 이거 뭔가 수정해야함 -->
			<c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.nickname eq requestScope.board.writer.nickname}">
				<button onclick="location.href='${ pageContext.servletContext.contextPath }/board/update?no=${ requestScope.board.no }'">수정하기</button>				
			</c:if>
			<c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.nickname eq requestScope.board.writer.nickname
							or sessionScope.loginMember.role eq 'ADMIN' }">
				<button onclick="location.href='${ pageContext.servletContext.contextPath }/board/delete?no=${ requestScope.board.no }'">삭제하기</button>
			</c:if>
		</div>
		<div class="tableArea">
				<table align="center" width="800px">
					<tr>
						<td>글번호</td>
						<td><c:out value="${ requestScope.board.no }"/></td>
						<td>분야 </td>
						<td><span><c:out value="${ requestScope.board.category.name }"/></span></td>
						<td>제목 </td>
						<td><span><c:out value="${ requestScope.board.title }"/></span></td>
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
					<tr>
						<td colspan="6">
							<p id="content"><c:out value="${ requestScope.board.body }"/></p>
						</td>
					</tr>
				</table>
				<br>
		</div>
		
	</div>
	
	<div class="replyArea">
		<div class="replyWriteArea">
			<table align="center">
				<tr>
					<td>댓글 작성</td>
					<td><textArea rows="3" cols="80" id="replyContent"></textArea></td>
					<td><button id="addReply">댓글 등록</button></td>
				</tr>
			</table>
		</div>
		<div id="replySelectArea">
			<table id="replySelectTable" border="1" align="center">
			</table>
		</div>
	</div>
	
	<script>
		$(function(){
			$("#addReply").click(function(){
				var writer = ${ sessionScope.loginMember.nickname };
				var content = $("#replyContent").val();
				
				console.log(writer);
				console.log(content);
				
				$.ajax({
					url:"${ pageContext.servletContext.contextPath }/board/insertReply",
					data:{writer:writer, content:content},
					type:"post",
					success:function(data){
						console.log(data);
						var $replySelectTable = $("#replySelectTable");
						$replySelectTable.html('');
						
						for(var key in data){
							console.log(key);
						
							var $tr = $("<tr>");
							var $writerTd = $("<td>").text(data[key].bWriter).css("width","100px");
							var $contentTd = $("<td>").text(data[key].bContent).css("width","400px");
							var $dateTd = $("<td>").text(data[key].bDate).css("width","200px");
							
							$tr.append($writerTd);
							$tr.append($contentTd);
							$tr.append($dateTd);
							$replySelectTable.append($tr);
							
						}
					},
					error:function(){
						
					}
				});
			});
			
			
		});
	</script>
	
</body>
</html>