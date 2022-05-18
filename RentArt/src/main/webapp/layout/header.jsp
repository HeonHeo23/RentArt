<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://code.iconify.design/2/2.2.1/iconify.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
  <title>RentArt 렌트아트</title>
</head>
<body>
  <header class="header">
    <nav class="nav">
      <div class="nav-left">
        <div class="nav-logo">
          <a href="/main">Rent Art</a>
        </div>
        <ul class="nav-navbar">
          <li><a href="/discover">작품보기</a></li>
          <li><a href="/artist">작가소개</a></li>
          <li><a href="/magazine">매거진</a></li>
          <li><a href="/review">후기</a></li>
        </ul>
      </div>
      <div class="nav-right">
        <div class="nav-icons">
          <a onclick="showSearch()"><i class="iconify" data-icon="carbon:search"></i></a> 
          <i class="iconify" data-icon="ph:shopping-cart-light"></i>
          <a href="/favorite"><i class="iconify" data-icon="akar-icons:heart"></i></a>
        </div>
        <c:choose>
          <c:when test="${sessionScope.principal != null}">
            <ul class="nav-user">
              <li><a href="/logout">로그아웃</a></li>
            </ul>
          </c:when>
          <c:otherwise>
            <ul class="nav-user">
              <li><a href="/login">로그인</a></li>
              <li><a href="/join">회원가입</a></li>
            </ul>
          </c:otherwise>
        </c:choose>
      </div>
    </nav>
      <div class="header-search inactive" id="search">
        <form class="header-search-container" action="/discover" method="get">
          <select name="f" class="header-search-select">
            <option value="p_name" ${param.f.equals("p_name")?'selected':''}>제목</option>
            <option value="artist_name" ${param.f.equals("artist_name")?'selected':''}>작가명</option>
          </select>
          <input type="text" name="q" value="${param.q}" class="header-search-input" />
          <button type="submit" class="header-search-submit">검색</button>
        </form>
      </div>
  </header>