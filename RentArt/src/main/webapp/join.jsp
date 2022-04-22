<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
    <div class="form-container">
      <div class="form-title">로그인</div>
      <form action="user" method="post">
        <input class="form-input" type="email" placeholder="이메일" name="email">
        <input class="form-input input-last" type="password" placeholder="비밀번호" name="password">
        <button class="form-submit" type="submit" name="cmd" value="loginAction">로그인</button>
      </form>
    </div>
<%@ include file="layout/footer.jsp" %>