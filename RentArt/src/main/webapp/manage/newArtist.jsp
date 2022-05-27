<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작가 등록하기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css" />
</head>
<body>
  <form method="post" action="/manage/artist">
    <table style="text-align: center;width:100%;border:1px solid #dddddd">
		<thead>
			<tr style="border:1px solid #000">
				<th class="thead">작가명</th>
				<th colspan="2" style="background-color: #eeeeee;">
					<!-- 자동완성 방지용  --><input type="text" class="full-width" name="name" autocomplete="none"><!-- 자동완성 방지용  -->
				</th>						
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="thead">ID</td>
				<td style="text-align:left;">${last}</td>
			</tr>
			<tr>
				<td class="thead">비밀번호</td>
				<td><input type="password" class="full-width" name="password" autocomplete="new-password"></td>
			</tr>
			<tr>
				<td class="thead">작가 소개</td>
				<td class="tcontent tcontent-small">
					<textarea name="text" id="" class="" style="width:100%;height:100%"></textarea>
				</td>						
			</tr>
		</tbody>
	</table>
	<input type="hidden" name="id" value="${last}">
	<button type="submit" name="cmd" value="new">등록하기</button>
  </form>
</body>
</html>