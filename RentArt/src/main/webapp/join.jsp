<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
  <main class="form-section">
    <div class="form-container">
      <div class="form-title">회원 가입</div>
      <form action="user" method="post">
        <input class="form-input" type="email" placeholder="이메일" name="email">
        <input class="form-input input-last" type="password" placeholder="비밀번호" name="password">
        <input class="form-input" type="text" placeholder="이름" name="name" required>
        <div class="form-div">
          <div class="email">
            <input class="form-input input-last" type="text" placeholder="주소" name="address" readonly required>
          </div>
          <div class="email-button">
            <button class="form-submit" type="button">우편번호 찾기</button>
          </div>
        </div>
        <button class="form-submit" type="submit" name="cmd" value="joinAction">회원 가입</button>
      </form>
    </div>
  </main>
<%@ include file="layout/footer.jsp" %>