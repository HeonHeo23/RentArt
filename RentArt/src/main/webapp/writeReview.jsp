<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성하기</title>
</head>
<body>
  <form method="post" action="/review">
    <table style="text-align: center;width:100%;border: 1px solid #dddddd">
		<thead>
			<tr>
				<th colspan="2" style="background-color: #eeeeee; text-align: center;">리뷰 작성</th>						
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="text" style="width:97%;height:32px;padding:5px 10px;" placeholder="제목" name="title" maxlength="256"></td>
			</tr>
			<tr>
				<td><textarea style="width:97%;height:50vh;padding:10px;" placeholder="글 내용" name="content" maxlength="2048"></textarea></td>						
			</tr>
		</tbody>
	</table>
  <input type="hidden" name="prodNo" value="${param.prodNo}">
  <button type="submit" name="cmd" value="writeAction">글쓰기</button>
  </form>
</body>
</html>