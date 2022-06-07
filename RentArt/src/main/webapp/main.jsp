<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
  <main>
    <div class="container main">
      <h2>미술품 렌탈의 시작, Rent Art</h2>
      <div class="carousel">
        <div class="carousel-container">
          <c:forEach var="l" items="${list}" varStatus="loop">
          <a href="/detail?no=${l.getpId()}" class="carousel__photo ${loop.index == 0?'initial':''}">
            <img src="/img/product/${l.getpImg()}" alt="${l.getpName()}">
            <div class="carousel__view">
              <div class="carousel__title">${l.getpName()} (${l.getArtist()} 작가)</div>
            </div>        
          </a>
          </c:forEach>
          <div class="carousel__button--next"></div>
          <div class="carousel__button--prev"></div>
        </div>
      </div>
      <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit.<br>
        Feugiat pretium proin vel magna magna arcu egestas.<br>
        Lacus sit venenatis facilisi nulla.</p>
    </div>
  </main>
  <script src="/js/carousel.js"></script>
<%@ include file="layout/footer.jsp" %>