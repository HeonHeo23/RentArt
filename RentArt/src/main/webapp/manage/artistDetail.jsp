<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script src="/js/password.js"></script>
<meta charset="UTF-8">
<title>작가 정보 수정하기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css" />
</head>
<body>
  <form method="post" action="/manage/artist">
    <table style="text-align: center;width:100%;border:1px solid #dddddd">
		<thead>
			<tr style="border:1px solid #000">
				<th class="thead">작가명</th>
				<th colspan="2" style="background-color: #eeeeee;"><input type="text" class="width-850" name="name" value="${dto.getArtistName()}"></th>						
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="thead">작가ID</td>
				<td style="text-align:left;">${dto.getArtistId()}</td>
			</tr>
			<tr>
				<td class="thead">비밀번호</td>
				<td class="left">
					<button type="button" id="button" class="width-10" onclick="showPassword()">보이기</button>
					<input type="password" id="password" class="width-90" name="password" value="${dto.getPassword()}">
				</td>
			</tr>
			<tr>
				<td class="thead">작가 소개</td>
				<td class="tcontent tcontent-small">
					<textarea name="text" id="" class="" style="width:100%;height:100%">${dto.getArtistInfo()}</textarea>
				</td>						
			</tr>
		</tbody>
	</table>
	<input type="hidden" name="no" value="${param.no}">
	<button type="submit" name="cmd" value="update">수정하기</button>
	<button type="submit" name="cmd" value="delete" style="color:red">삭제하기</button>
  </form>
</body>
</html>