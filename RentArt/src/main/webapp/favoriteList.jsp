<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
  <main class="wrapper">
    <div class="container">
      <header>
        <h1 class="page-title">${userName}님의 찜 목록</h1>
      </header>
      <div class="discover-middle">
        <div class="discover-count">
          총 <fmt:formatNumber type="number" value="${count}"/>점의 작품
        </div>
      </div>
      <div>
        <div class="view favorite-view">
          <c:forEach var="l" items="${list}">
          <div class="card">
            <a class="card-img-wrap" href="/detail?no=${l.getpId()}">
              <div class="card-img-mask">
                <img class="card-img" src="/img/product/${l.getpImg()}" alt="">
              </div>
            </a>
            <div class="card-info">
              <div class="card-text">
                <h4 class="card-title">${l.getpName()}</h4>
                <div class="card-artist card-text-margin">${l.getArtist()}</div>
                <div class="card-size">${l.getpSize()}호</div>
              </div>
              <div class="card-status">
                <c:choose>
                <c:when test="${fList.contains(l.getpId())}">
                  <a href="/favorite?cmd=remove&prodNo=${l.getpId()}">
                    <i class="iconify icon-pink" data-icon="ant-design:heart-filled"></i>
                  </a>
                </c:when>
                <c:otherwise>
                  <a href="/favorite?cmd=add&prodNo=${l.getpId()}">
                    <i class="iconify" data-icon="akar-icons:heart"></i>
                  </a>
                </c:otherwise>
                </c:choose>
                <c:choose>
                <c:when test="${l.ispIsRent()}">
                  <div class="card-rent color-brown">
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
          </div>
          </c:forEach>
        </div>
        <form>
          <%@ include file="layout/pager.jsp" %>
        </form>
      </div>
    </div>
  </main>
<%@ include file="layout/footer.jsp" %>