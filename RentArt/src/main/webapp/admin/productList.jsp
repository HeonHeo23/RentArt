<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/admin/header.jsp" %>
  <main class="admin-wrapper">
    <div class="admin-content">
      <header>
        <h1 class="admin-title">작품 관리</h1>
        <p class="admin-title-sub">작품을 관리 할 수 있습니다.</p>
      </header>
      <div class="detail-cards">
        <c:forEach var="l" items="${list}">
        <a class="detail-card" onclick="showPopUp('/admin/detail?no=${l.getpId()}')">
          <div class="detail-card-img">
            <div class="card-img-wrapper">
              <img src="/img/product/${l.getpImg()}" alt="">
            </div>
          </div>
          <div class="card-texts">
            <h4 class="detail-card-top"> ${l.getpName()} </h4>
            <div class="detail-card-bottom">
              ${l.getpSize()}호
            <c:choose>
            <c:when test="${l.ispIsRent()}">
              <div class="color-brown">
                <i class="iconify" data-icon="akar-icons:circle-fill"></i> 
                대여중
              </div>
            </c:when>
            <c:otherwise>
              <div class="card-rent color-blue">
                <i class="iconify" data-icon="akar-icons:circle-fill"></i> 
                대여가능
              </div>
            </c:otherwise>
            </c:choose>
            </div>
          </div>
        </a>
        </c:forEach>
      </div>
    </div>
  </main>
</body>
</html>