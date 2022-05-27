<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
<script src="/js/popup.js" type="text/javascript"></script>
   <main class="artist-section">
    <div class="artist-wrapper">
      <header class="artist-header">
        <h1 class="page-title">${artist.getArtistName()} 작가</h1>
      </header>
      <div class="artist-info">
        <p>
          ${artist.getArtistInfo()} 
        </p>
      </div>
      <div class="artist-view">
        <header class="section-header-wrap">
          <h2 class="section-header">
            작품 감상하기
          </h2>
        </header>
        <div class="view-middle">
          총 <fmt:formatNumber value="${count}"/>개의 작품
        </div>
        <div class="detail-cards view-margin">
          <c:forEach var="l" items="${list}">
          <a class="card-artist-detail" href="/detail?no=${l.getpId()}">
            <div class="detail-card-img">
              <div class="card-img-wrapper-big">
                <img src="/img/product/${l.getpImg()}" alt="">
              </div>
            </div>
            <div class="card-texts">
              <h4 class="detail-card-top">새벽의 꽃</h4>
              <div class="detail-card-bottom">
                2호
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
      <section class="detail-review">
        <h2 class="section-header">작가의 말</h2>
        <table class="review-table">
          <c:choose>
          <c:when test="${notice.size()!=0}">
          <c:forEach items="${notice}" var="r">
          <tr class="review-row">
            <td class="review-num">${r.getRownum()}</td>
            <td class="review-title"><a onclick="showPopUp('/notice?no=${r.getnId()}&cmd=view')">${r.getnTitle()}</a></td>
            <td class="review-name">${artist.getArtistName()}</td>
            <td class="review-date"><fmt:formatDate value="${r.getnRegDate()}" pattern="yyyy.MM.dd"/></td>
          </tr>
          </c:forEach>
          </c:when>
          <c:otherwise>
          <tr class="review-row">
            <td class="review-none">등록된 공지가 없습니다.</td>
          </tr>
          </c:otherwise>
          </c:choose>
        </table>
      </section>
    </div>
  </main>
<%@ include file="layout/footer.jsp" %>