<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/admin/header.jsp" %>
  <main class="admin-wrapper">
    <div class="admin-content">
      <header>
        <h1 class="admin-title">소개 글 관리</h1>
        <p class="admin-title-sub">작가 페이지에 표시될 소개 글을 작성해주세요.</p>
      </header>
      <form action="/admin" method="post">
        <textarea name="text" id="" class="admin-textarea">${artistInfo}</textarea>
        <button class="admin-button bg-blue admin-button-right float-right" name="cmd" value="updateInfo">수정하기</button>
      </form>
    </div>
  </main>
</body>
</html>