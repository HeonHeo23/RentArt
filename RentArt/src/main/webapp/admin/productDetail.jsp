<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작품 수정하기</title>
<script type="text/javascript">
window.onload = (event) => {
    checkP();
};
function checkP() {
  const theme = ${dto.getpTheme()};
  checkF("theme-"+theme);
}
function checkF(p) {
  document.getElementById(p).checked = true;
}
</script>
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
.full-width{
  width:100%;
  display:flex;
}
</style>
</head>
<body>
  <form method="post" action="/admin/product">
    <table style="text-align: center;width:100%;border:1px solid #dddddd">
		<thead>
			<tr style="border:1px solid #000">
				<th class="thead">작품명</th>
				<th colspan="2" style="background-color: #eeeeee;"><input type="text" class="full-width" name="name" value="${dto.getpName()}"></th>						
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="thead">가격</td>
				<td><input type="number" class="full-width" name="price" value="${dto.getpPrice()}"></td>
				</td>						
			</tr>
			<tr>
				<td class="thead">제작년도</td>
				<td><input type="number" class="full-width" name="year" value="${dto.getpYear()}"></td>						
			</tr>
			<tr>
				<td class="thead">재료</td>
				<td>
					<textarea name="material" id="" class="" style="width:100%;height:100%">${dto.getpMaterial()}</textarea>
				</td>						
			</tr>
			<tr>
				<td class="thead">상품설명</td>
				<td class="tcontent">
					<textarea name="text" id="" class="" style="width:100%;height:100%">${dto.getpInfo()}</textarea>
				</td>						
			</tr>
			<tr>
				<td class="thead">테마</td>
				<td>
					<div class="filter-buttons full-width">
			            <div class="filter-button">
			            	<input type="radio" name="theme" id="theme-1" value="1">
			            	<label for="filter-theme-1">인물</label>
			            </div>
			            <div class="filter-button">
			            	<input type="radio" name="theme" id="theme-2" value="2">
			            	<label for="filter-theme-2">추상</label>
			            </div>
			            <div class="filter-button">
			            	<input type="radio" name="theme" id="theme-3" value="3">
			            	<label for="filter-theme-3">풍경</label>
			            </div>
			            <div class="filter-button">
			            	<input type="radio" name="theme" id="theme-4" value="4">
			            	<label for="filter-theme-4">정물</label>
			            </div>
			        </div>
			    </td>
			</tr>
			<tr>
				<td class="thead">사이즈</td>
				<td>
					<input type="number" class="full-width" name="size" value="${dto.getpSize()}">
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