<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/manage/header.jsp" %>
  <main class="form-section">
    <div class="form-container">
      <div class="form-title">관리자 로그인</div>
      <form action="/manage" method="post">
        <input class="form-input" type="text" placeholder="아이디" name="id" required>
        <input class="form-input input-last" type="password" placeholder="비밀번호" name="password" required>
        <button class="form-submit bg-black" type="submit" name="cmd" value="loginAction">로그인</button>
      </form>
    </div>
  </main>
</body>
</html>