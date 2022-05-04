<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 보기</title>
<style type="text/css">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  text-align: center;
  padding:10px;
}
.thead {
  width:90px;
  background:#eee;
}
.tcontent{
  height:500px;
  vertical-align:baseline;
  text-align:left;
}
</style>
</head>
<body>
  <form method="post" action="/review">
    <table style="text-align: center;width:100%;border:1px solid #dddddd">
		<thead>
			<tr style="border:1px solid #000">
				<th colspan="2" style="background-color: #eeeeee;"><b>${dto.getrTitle()} (작성자: ${dto.getUserName()})</b></th>						
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="thead">내용</td>
				<td class="tcontent">${dto.getrContent()}</td>						
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