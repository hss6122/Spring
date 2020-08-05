<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="modify" method="post">
			<input type="hidden" name="bId" value="${bbsDTO.bId}">
			<tr>
				<td>번호</td>
				<td>${bbsDTO.bId}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName"
					value="${bbsDTO.bName}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle"
					value="${bbsDTO.bTitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="bContent">${bbsDTO.bContent}</textarea></td>
			</tr>
			<c:if test="${bbsDTO.bFileName ne null}">
			<tr>
				<td>첨부파일</td>
				<td align="left"><a href="fileDownload?bFileName=${bbsDTO.bFileName}">${bbsDTO.bFileName}</a></td>			
			</tr>
			</c:if>
			<tr>
				<td colspan="2"><input type="submit" value="수정"> &nbsp;&nbsp; <a href="list">목록보기</a> &nbsp;&nbsp; <a href="delete?bId=${bbsDTO.bId}">삭제</a> &nbsp;&nbsp; <a href="reply_view?bId=${bbsDTO.bId}">답변</a></td>
			</tr>
		</form>
	</table>

</body>
</html>