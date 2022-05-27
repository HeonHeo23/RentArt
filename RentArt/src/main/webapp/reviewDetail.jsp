<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 보기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css" />
</head>
<body>
  <form method="post" action="/review">
    <table style="text-align: center;width:100%;border:1px solid #BBB">
		<thead>
			<tr style="border:1px solid #000">
				<th colspan="2" style="background-color: #eeeeee;"><b>${dto.getrTitle()}</b></th>						
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="thead">작품명</td>
				<td>${dto.getpName()} <a href="/detail?no=${dto.getpId()}" target="_blank">(바로가기 →)</a></td>						
			</tr>
			<tr>
				<td class="thead">작성자</td>
				<td>${dto.getUserName()}</td>						
			</tr>
			<tr>
				<td class="thead">내용</td>
				<td class="tcontent treview">${dto.getrContent()}</td>						
			</tr>
			<tr>
				<td class="thead">등록일자</td>
				<td><fmt:formatDate value="${dto.getrRegDate()}" pattern="yyyy.MM.dd" /> </td>						
			</tr>
		</tbody>
	</table>
  </form>
</body>
</html>