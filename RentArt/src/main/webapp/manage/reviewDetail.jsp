<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 수정하기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css" />
</head>
<body>
  <form method="post" action="/manage/review">
    <table style="text-align: center;width:100%;border:1px solid #dddddd">
		<thead>
			<tr style="border:1px solid #000">
				<th class="thead">제목</th>
				<th colspan="2" style="background-color: #eeeeee;"><input type="text" class="full-width" name="title" value="${dto.getrTitle()}"></th>						
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="thead">작성자 ID</td>
				<td><input type="number" class="full-width" name="userKey" value="${dto.getUserKey()}"></td>
			</tr>
			<tr>
				<td class="thead">작품 ID</td>
				<td><input type="number" class="full-width" name="pId" value="${dto.getpId()}"></td>
			</tr>
			<tr>
				<td class="thead">내용</td>
				<td class="tcontent tcontent-small">
					<textarea name="text" id="" class="" style="width:100%;height:100%">${dto.getrContent()}</textarea>
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