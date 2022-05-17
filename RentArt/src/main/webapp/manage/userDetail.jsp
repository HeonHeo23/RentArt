<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function showPassword(){
	let elem = document.getElementById("password");
	let value = elem.getAttribute("type");
	if(value == ("password")){
		elem.setAttribute("type","text");
	} else {
		elem.setAttribute("type","password");
	}
	
	let elem2 = document.getElementById("button");
	value2 = elem2.innerHTML;
	
	if(value2 == "가리기"){
		elem2.innerHTML = "보이기";
	} else {
		elem2.innerHTML = "가리기";
	}
}
</script>
<meta charset="UTF-8">
<title>사용자 정보 수정하기</title>
<style type="text/css">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  text-align: center;
  padding:10px;
}
.left{
  text-align:left;
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
  width:850px;
  display:flex;
}
.width-90{
  width:773px;
}
.width-10{
  width:70px;
}
</style>
</head>
<body>
  <form method="post" action="/manage/user">
    <table style="text-align: center;width:100%;border:1px solid #dddddd">
		<thead>
			<tr style="border:1px solid #000">
				<th class="thead">이름</th>
				<th colspan="2" style="background-color: #eeeeee;"><input type="text" class="full-width" name="name" value="${dto.getName()}"></th>						
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="thead">사용자ID</td>
				<td class="left">${dto.getKey()}</td>
			</tr>
			<tr>
				<td class="thead">비밀번호</td>
				<td class="left">
					<button type="button" id="button" class="width-10" onclick="showPassword()">보이기</button>
					<input type="password" id="password" class="width-90" name="password" value="${dto.getPassword()}">
				</td>
			</tr>
			<tr>
				<td class="thead">이메일</td>
				<td><input type="email" class="full-width" name="email" value="${dto.getEmail()}"></td>						
			</tr>
			<tr>
				<td class="thead">주소</td>
				<td><input type="text" class="full-width" name="address" value="${dto.getAddress()}"></td>						
			</tr>
		</tbody>
	</table>
	<input type="hidden" name="no" value="${param.no}">
	<button type="submit" name="cmd" value="update">수정하기</button>
	<button type="submit" name="cmd" value="delete" style="color:red">삭제하기</button>
  </form>
</body>
</html>