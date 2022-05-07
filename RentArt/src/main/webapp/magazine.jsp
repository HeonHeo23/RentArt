<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
<main class="discover-section">
    <div class="discover-wrapper">
      <c:set var="month"><fmt:formatDate value="${dto.getRegDate()}" pattern="M" /></c:set>
      <h1 class="discover-header artist-header">
        Rent Art 매거진
      </h1>
      <nav class="magazine-nav">
        <c:choose>
        <c:when test="${(no-1)>0}">
          <a class="flex-center magazine-button-left bg-blue" href="?no=${no-1}">
             ← 이전 호 : ${month-1}월호
          </a>
        </c:when>
        <c:otherwise>
          <span class="flex-center magazine-button-left bg-blue">
             ← 이전 호 : 없음
          </span>
        </c:otherwise>
        </c:choose>
        <div class="magazine-nav-title flex-center">
          ${month}월호: ${dto.getTitle()}
        </div>
        <c:choose>
        <c:when test="${no+1 <= lastNo}">
          <a class="flex-center magazine-button-right bg-blue" href="?no=${no+1}">
            ${month+1}월호 : 다음 호 →
          </a>
        </c:when>
        <c:otherwise>
          <span class="flex-center magazine-button-right bg-blue">
            없음 : 다음 호 →
          </span>
        </c:otherwise>
        </c:choose>
      </nav>
      <div class="magazine-title-wrapper">
        <h2 class="magazine-title">${dto.getTitle()}</h2>
      </div>
      <div class="magazine-content">
        ${dto.getContent()}
      </div>
    </div>
  </main>
<%@ include file="layout/footer.jsp" %>