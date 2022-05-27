<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
<script src="/js/detail.js"></script>
<script type="text/javascript">
window.onload = () => changeFee(${fee});
</script>
<script src="/js/popup.js" type="text/javascript"></script>
  <main class="detail">
    <div class="detail-wrapper">
      <div class="detail-top">
        <div class="detail-img">
          <img src="/img/product/${detail.getpImg()}" alt="${detail.getpName()} 이미지">
        </div>
        <div class="detail-banner">
          <img src="/img/banner.png" alt="배너">
        </div>
      </div>
      <div class="detail-info">
        <h2 class="info-title">
          ${detail.getpName()}
        </h2>
        <hr class="info-hr">
        <div class="info-row">
          <div class="row-left">
            작가
          </div>
          <div class="row-right">
            ${detail.getArtist()}
          </div>
        </div>
        <div class="info-row">
          <div class="row-left">
            제작년도
          </div>
          <div class="row-right">
            ${detail.getpYear()}
          </div>
        </div>
        <div class="info-row">
          <div class="row-left">
            재료
          </div>
          <div class="row-right">
            ${detail.getpMaterial()}
          </div>
        </div>
        <div class="info-row">
          <div class="row-left">
            크기
          </div>
          <div class="row-right">
            ${detail.getpSize()}호
          </div>
        </div>
        <div class="info-row">
          <div class="row-left">
            테마
          </div>
          <div class="row-right">
            ${detail.getpThemeString()}
          </div>
        </div>
        <hr class="info-hr">
        <div class="info-row info-price">
          <div class="row-left-price">
            구매가
          </div>
          <div class="row-right-price">
            <fmt:formatNumber value="${detail.getpPrice()}" /> 원
          </div>
        </div>
        <hr class="info-hr hr-grey">
        <div class="info-row info-price">
          <div class="row-left-price">
            렌트가
          </div>
          <div class="row-right-price">
            월 <fmt:formatNumber value="${fee}" /> 원
          </div>
        </div>
        <div class="info-row info-price">
          <div class="row-left-price">
            렌트기간
          </div>
          <div class="row-right">
            <input type="number" class="row-right-input" name="months" id="rentMonth" max="12" min="3" value="3" oninput="changeFee(${fee})">
            개월
          </div>
        </div>
        <hr class="info-hr hr-grey">
        <div class="info-row info-price row-discount">
          <div class="row-left-price">
            할인
          </div>
          <div class="row-right-price">
            - 9,000 원
          </div>
        </div>
        <hr class="info-hr">
        <div class="info-price info-row-final">
          <div class="row-left-price">
            최종 렌트가
          </div>
          <div class="row-right-price">
            <div class="row-right-top">
              <span id="totalPrice"></span> 원
            </div>
            <div class="row-right-bottom">
              월 <span id="finalMonthlyPrice"><fmt:formatNumber value="${fee}" /></span> 원
            </div>
          </div>
        </div>
        <div class="info-buttons">
        <c:set var="rent" value="${detail.ispIsRent()}" />
        <c:if test="${rent}">
          <div class="info-buttons-alert">렌트 중</div>
        </c:if>
          <button class="info-button bg-brown">구매 하기</button>
          <button class="info-button bg-blue">렌트 하기</button>
        </div>
      </div>
      <div class="detail-left">
        <section class="detail-section">
          <h2 class="detail-title-big">${detail.getpName()}</h2>
          <article>
            <h3 class="detail-title-small">작품 설명</h3>
            <p class="detail-para">
              ${detail.getpInfo()} 
            </p>
          </article>
        </section>
        <section class="detail-section">
          <h2 class="detail-title-big">${detail.getArtist()} 작가</h2>
          <article>
            <aside class="deatil-artist-link">
              <a href="/artist?no=${detail.getArtistId()}">${detail.getArtist()} 작가 메인으로 →</a>
            </aside>
            <h3 class="detail-title-small">${detail.getArtist()} 작가 소개</h3>
            <p class="detail-para">
              ${artistInfo} 
            </p>
          </article>
          <section>
            <h3 class="detail-title-small">작가의 작품 감상하기</h3>
            <div class="detail-cards">
              <c:forEach var="l" items="${list}">
              <a class="detail-card" href="/detail?no=${l.getpId()}">
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
          </section>
        </section>
        <section class="detail-review">
          <div class="review-button-div">
            <button type="button" class="review-button bg-black" onclick="showPopUp('/review?prodNo=${param.no}&cmd=write')">리뷰 쓰기</button>
          </div>
          <h2 class="detail-title-big">리뷰</h2>
          <table class="review-table">
            <c:choose>
            <c:when test="${reviews.size()!=0}">
            <c:forEach items="${reviews}" var="r">
            <tr class="review-row">
              <td class="review-num">${r.getRownum()}</td>
              <td class="review-title"><a onclick="showPopUp('/review?no=${r.getrId()}&cmd=view')">${r.getrTitle()}</a></td>
              <td class="review-name">${r.getUserName()}</td>
              <td class="review-date"><fmt:formatDate pattern="yyyy.MM.dd" value="${r.getrRegDate()}" /></td>
            </tr>
            </c:forEach>
            </c:when>
            <c:otherwise>
            <tr class="review-row">
              <td class="review-none">등록된 리뷰가 없습니다.</td>
            </tr>
            </c:otherwise>
            </c:choose>
          </table>
        </section>
      </div>
    </div>
  </main>
<%@ include file="layout/footer.jsp" %>