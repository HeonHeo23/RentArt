<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매거진 등록하기</title>
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
  height:400px;
  vertical-align:baseline;
  text-align:left;
}
.full-width{
  width:100%;
  display:flex;
}
</style>
</head>
<body>
  <form method="post" action="/manage/magazine">
    <table style="text-align: center;width:100%;border:1px solid #dddddd">
		<thead>
			<tr style="border:1px solid #000">
				<th class="thead">제목</th>
				<th colspan="2" style="background-color: #eeeeee;"><input type="text" class="full-width" name="title"></th>						
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="thead">내용</td>
				<td class="tcontent">
					<textarea name="text" id="" class="" style="width:100%;height:100%"></textarea>
				</td>						
			</tr>
			<tr>
				<td class="thead">등록(발행)<br>일자</td>
				<td><input type="date" name="date" value=""></td>
			</tr>
		</tbody>
	</table>
	<button type="submit" name="cmd" value="new">등록하기</button>
  </form>
</body>
</html>