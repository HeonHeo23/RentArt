<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://code.iconify.design/2/2.2.1/iconify.min.js"></script>
  <script type="text/javascript">
	function showPopUp(url) {
	  let width = 1000;
	  let height = 650;
	  let left = (window.screen.width / 2) - (width / 2);
	  let top = (window.screen.height / 4);
	  
	  let windowStatus = 'width='+width+', height='+height+', left='+left+', top='+top+', scrollbars=yes, status=yes, resizable=yes, titlebar=yes';
		
	  window.open(url, "글쓰기", windowStatus);
	}
  </script>
  <link rel="stylesheet" href="/css/manage/manage.css">
  <title>RentArt 렌트아트 관리자 페이지</title>
</head>
<body>
  <header class="manage-header">
    <div>
      <a class="manage-logout" href="/logout">로그아웃</a>
    </div>
    <div class="logo">
      <a href="/manage">Rent Art Manager Page</a>
    </div>
  </header>