<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:300,400,500,700&display=swap" rel="stylesheet">
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <script src="https://code.iconify.design/2/2.2.1/iconify.min.js"></script>
  <link rel="stylesheet" href="/css/admin/admin.css">
  <title>RentArt 렌트아트</title>
</head>
  <header class="admin-header">
      <div class="logo">
        <a href="/admin">Rent Art Artist Page</a>
	  </div>
  </header>
  <main class="form-section">
    <div class="form-container">
      <div class="form-title">작가 로그인</div>
      <form action="/admin" method="post">
        <input class="form-input" type="text" placeholder="작가 고유 번호" name="id" required>
        <input class="form-input input-last" type="password" placeholder="비밀번호" name="password" required>
        <button class="form-submit" type="submit" name="cmd" value="loginAction">로그인</button>
      </form>
    </div>
  </main>
</body>
</html>