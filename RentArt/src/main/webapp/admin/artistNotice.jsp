<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/admin/header.jsp" %>
  <main class="admin-wrap">
    <div class="admin-container">
      <a onclick="showPopUp('/admin/notice/write')" class="admin-btn btn admin-btn-right bg-blue">글쓰기</a>
      <header>
        <h1 class="admin-title">작가의 말(공지) 관리</h1>
        <p class="admin-subtitle">작가의 말(공지)를 추가, 수정, 삭제 할 수 있습니다.</p>
      </header>
      <table class="review-table">
        <c:choose>
          <c:when test="${notice.size()!=0}">
          <c:forEach items="${notice}" var="r">
          <tr class="review-row">
            <td class="review-num">${r.getRownum()}</td>
            <td class="review-title"><a class="link" onclick="showPopUp('/admin/notice?no=${r.getnId()}')">${r.getnTitle()}</a></td>
            <td class="review-name">${sessionScope.adminPrincipal.getArtistName()}</td>
            <td class="review-hits">${r.getnHits()}회</td>
            <td class="review-date"><fmt:formatDate value="${r.getnRegDate()}" pattern="yyyy.MM.dd"/></td>
          </tr>
          </c:forEach>
          </c:when>
          <c:otherwise>
          <tr class="review-row">
            <td class="review-none">등록된 공지가 없습니다.</td>
          </tr>
          </c:otherwise>
          </c:choose>
      </table>
    </div>
  </main>