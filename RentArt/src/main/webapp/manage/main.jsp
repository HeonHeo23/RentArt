<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/manage/header.jsp" %>
  <main class="manage-main">
    <div class="manage-main-btn-group">
      <a href="/manage/product" class="btn manage-main-btn btn1">
        <i class="iconify" data-icon="bi:image-fill" style="color: white;" data-width="150" data-height="150"></i>
        <div>작품 관리</div>
      </a>
      <a href="/manage/user" class="btn manage-main-btn btn2">
        <i class="iconify" data-icon="bi:person-fill" style="color: white;" data-width="150" data-height="150"></i>
        <div>사용자 관리</div>
      </a>
      <a href="/manage/artist" class="btn manage-main-btn btn3">
        <i class="iconify" data-icon="dashicons:art" style="color: white;" data-width="150" data-height="150"></i>
        <div>작가 관리</div>
      </a>
      <a href="/manage/review" class="btn manage-main-btn btn4">
        <i class="iconify" data-icon="heroicons-outline:pencil-alt" style="color: white;" data-width="150" data-height="150"></i>
        <div>리뷰 관리</div>
      </a>
      <a href="#" class="btn manage-main-btn btn5">
        <i class="iconify" data-icon="fluent:box-16-filled" style="color: white;" data-width="150" data-height="150"></i>
        <div>주문 관리</div>
      </a>
      <a href="/manage/magazine" class="btn manage-main-btn btn6">
        <i class="iconify" data-icon="ooui:articles-rtl" style="color: white;" data-width="150" data-height="150"></i>
        <div>매거진 관리</div>
      </a>
    </div>
  </main>
  <%@ include file="/layout/manage/footer.jsp" %> 