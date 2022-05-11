<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/admin/header.jsp" %>
  <main class="admin-wrapper">
    <div class="form-container form-margin-top">
      <div class="form-title">작가 정보 수정</div>
      <form action="/admin" method="post">
        <input class="form-input" type="text" placeholder="이름" name="name" value="${artist.getArtistName()}" required>
        <input class="form-input" type="password" placeholder="현재 비밀번호" name="password" required>
        <input class="form-input input-last" type="password" placeholder="새 비밀번호" name="newPassword" required>
        <button class="form-submit" type="submit" name="cmd" value="updateArtist">수정하기</button>
      </form>
    </div>
  </main>
</body>
</html>