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
  <link rel="stylesheet" href="/css/admin/admin.css">
  <title>RentArt 렌트아트 관리자 페이지</title>
</head>
<body>
  <header class="admin-header">
      <div class="logo">
        <a href="/admin">Rent Art Admin Page</a>
	  </div>
  </header>
  <aside class="admin-aside">
	<div class="admin-profile">
	  <span class="admin-profile-name">${sessionScope.adminPrincipal.getArtistName()}</span> 작가님<br>환영합니다.
	</div>
    <div class="admin-aside-buttons">
      <button class="admin-button bg-blue">글쓰기</button>
      <button class="admin-button bg-blue">작품 등록</button>
    </div>
    <hr class="admin-aside-hr">
	  <nav>
		<ul class="admin-nav-ul">
		  <li class="admin-nav-header">
            <a href="">작가 페이지 관리</a>
          </li>
		  <li class="admin-nav-li">
            <a href="/admin/artistInfo">소개 글 관리</a>
          </li>
		  <li class="admin-nav-li">
            <a href="/admin/artist">작가 정보 수정</a>
          </li>
		  <li class="admin-nav-li">
            <a href="/admin/artistNotice">작가의 말(공지) 관리</a>
          </li>
        </ul>
        <hr class="admin-aside-hr">
		<ul class="admin-nav-ul">
		  <li class="admin-nav-header">
            <a href="/admin/product">작품 관리</a>
          </li>
          <li class="admin-nav-li">
            <a href="/admin/product">작품 관리</a>
          </li>
        </ul>
        <hr class="admin-aside-hr">
		<ul class="admin-nav-ul">
		  <li class="admin-nav-header">
            <a href="/logout">로그아웃</a>
          </li>
        </ul>
        <hr class="admin-aside-hr">
		<ul class="admin-nav-ul">
		  <li class="admin-nav-header">
            <a href="">회원 탈퇴</a>
          </li>
        </ul>
	  </nav>
	</aside>