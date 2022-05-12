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
  <form method="post" action="/admin/notice">
    <table style="text-align: center;width:100%;border:1px solid #dddddd">
		<thead>
			<tr style="border:1px solid #000">
				<th class="thead">제목</th>
				<th colspan="2" style="background-color: #eeeeee;"><textarea name="title" id="" class="" style="width:100%;height:100%">${dto.getnTitle()}</textarea></b></th>						
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="thead">내용</td>
				<td class="tcontent">
					<textarea name="text" id="" class="" style="width:100%;height:100%">${dto.getnContent()}</textarea>
				</td>						
			</tr>
		</tbody>
	</table>
	<input type="hidden" name="no" value="${param.no}">
	<button type="submit" name="cmd" value="updateNotice">수정하기</button>
  </form>
</body>
</html>