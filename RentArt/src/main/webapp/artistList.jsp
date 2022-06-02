<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
  <main class="wrapper">
    <div class="container">
      <header>
        <h1 class="page-title">작가 목록</h1>
        <div class="page-subtitle">Rent Art가 엄선한 작가들을 소개합니다.</div>
        <div class="middle">
          총 ${count}명의 작가
        </div>
      </header>
      <div class="view artist-view">
        <c:forEach var="l" items="${list}">
        <a class="card artist-card" href="/artist?no=${l.getArtistId()}">
          <div class="card-img-wrap card-img-big">
            <div class="card-img-mask">
              <img class="card-img" src="/img/product/${l.getpImg()}" alt="">
            </div>
          </div>
          <div class="card-info">
            <div class="card-text">
              <h4 class="card-title-big">${l.getArtistName()}</h4>
            </div>
            <div class="card-count">
              <div class="card-count-row">
                작품
              </div>
              <div class="card-count-row">
                ${l.getCountProduct()}
              </div>
            </div>
          </div>
        </a>
        </c:forEach>
      </div>
      <form>
        <%@ include file="layout/pager.jsp" %>
      </form>
    </div>
  </main>
<%@ include file="layout/footer.jsp" %>