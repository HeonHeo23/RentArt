<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <script src="https://code.iconify.design/2/2.2.1/iconify.min.js"></script>
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
          <li><a href="">작가소개</a></li>
          <li><a href="">매거진</a></li>
          <li><a href="">후기</a></li>
        </ul>
      </div>
      <div class="nav-right">
        <div class="nav-icons">
          <i class="iconify" data-icon="carbon:search"></i> 
          <i class="iconify" data-icon="ph:shopping-cart-light"></i>
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
  </header>