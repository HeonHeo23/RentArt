<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/admin/header.jsp" %>
  <main class="admin-wrapper">
    <div class="admin-content">
      <a onclick="showPopUp('/admin/notice/write')" class="admin-button bg-blue float-right button">글쓰기</a>
      <header>
        <h1 class="admin-title">작가의 말(공지) 관리</h1>
        <p class="admin-title-sub">작가의 말(공지)를 추가, 수정, 삭제 할 수 있습니다.</p>
      </header>
      <table class="table">
        <c:choose>
          <c:when test="${notice.size()!=0}">
          <c:forEach items="${notice}" var="r">
          <tr class="table-row">
            <td class="row-num">${r.getRownum()}</td>
            <td class="row-title"><a onclick="showPopUp('/admin/notice?no=${r.getnId()}')">${r.getnTitle()}</a></td>
            <td class="row-name">${sessionScope.adminPrincipal.getArtistName()}</td>
            <td class="">${r.getnHits()}회</td>
            <td class="row-date"><fmt:formatDate value="${r.getnRegDate()}" pattern="yyyy.MM.dd"/></td>
          </tr>
          </c:forEach>
          </c:when>
          <c:otherwise>
          <tr class="table-row">
            <td class="row-none">등록된 공지가 없습니다.</td>
          </tr>
          </c:otherwise>
          </c:choose>
      </table>
    </div>
  </main>