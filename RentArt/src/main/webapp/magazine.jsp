<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
  <main class="wrapper">
    <div class="container">
      <c:set var="month"><fmt:formatDate value="${dto.getRegDate()}" pattern="M" /></c:set>
      <header>
        <h1 class="page-title">Rent Art 매거진</h1>
        <div class="page-subtitle">전문 큐레이터가 발행하는 Rent Art 매거진은 매월 1일 만나보실 수 있습니다.</div>
      </header>
      <nav class="magazine-nav">
        <c:choose>
        <c:when test="${(no-1)>0}">
          <a class="magazine-button bg-blue" href="?no=${no-1}">
             ← 이전 호 : ${month-1}월호
          </a>
        </c:when>
        <c:otherwise>
          <span class="magazine-button bg-blue">
             ← 이전 호 : 없음
          </span>
        </c:otherwise>
        </c:choose>
        <div class="magazine-nav-title">
          ${month}월호: ${dto.getTitle()}
        </div>
        <c:choose>
        <c:when test="${no+1 <= lastNo}">
          <a class="magazine-button magazine-button-right bg-blue" href="?no=${no+1}">
            ${month+1}월호 : 다음 호 →
          </a>
        </c:when>
        <c:otherwise>
          <span class="magazine-button bg-blue">
            없음 : 다음 호 →
          </span>
        </c:otherwise>
        </c:choose>
      </nav>
      <div class="magazine-title-wrap">
        <h2 class="content-title-big page-title">${dto.getTitle()}</h2>
      </div>
      <div class="magazine-content">
        ${dto.getContent()}
      </div>
    </div>
  </main>
<%@ include file="layout/footer.jsp" %>