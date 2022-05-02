<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
<script type="text/javascript">
	const fee = ${fee};
	window.onload = () => changeFee();
	function changeFee(){
		let month = document.getElementById('rentMonth').value;
		document.getElementById('totalPrice').innerHTML = (fee * month).toLocaleString('en');
	}
</script>
  <main class="detail">
    <div class="detail-wrapper">
      <div class="detail-top">
        <div class="detail-img">
          <img src="/img/product/${detail.getpImg()}" alt="">
        </div>
        <div class="detail-banner">
          <img src="C:\Users\pc\git\RentArt\RentArt\src\main\webapp\img\banner.png" alt="">
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
            <input type="number" class="row-right-input" name="months" id="rentMonth" max="12" min="3" value="3" oninput="changeFee()">
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
              <span id="totalPrice">201,000</span> 원
            </div>
            <div class="row-right-bottom">
              월 <span id="finalMonthlyPrice"><fmt:formatNumber value="${fee}" /></span> 원
            </div>
          </div>
        </div>
        <div class="info-buttons">
          <button class="info-button bg-brown">구매 하기</button>
          <button class="info-button bg-blue">렌트 하기</button>
        </div>
      </div>
      <div class="detail-left">
        <section class="detail-section">
          <h2 class="detail-title-big">${detail.getpName()}</h3>
          <article>
            <h3 class="detail-title-small">작품 설명</h4>
            <p class="detail-para">
              ${detail.getpInfo()} 
            </p>
          </article>
        </section>
        <section class="detail-section">
          <h2 class="detail-title-big">${detail.getArtist()} 작가</h2>
          <article>
            <aside class="deatil-artist-link">
              <a href="">${detail.getArtist()} 작가 메인으로 →</a>
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
                </div>
              </a>
              </c:forEach>
            </div>
          </section>
        </section>
        <section class="detail-review">
          <h2 class="detail-title-big">리뷰</h2>
          <table class="review-table">
            <tr class="review-row">
              <td>1</td>
              <td>11월 2일부터 3월 7일까지 전시회 개최합니다.</td>
              <td>황보크리스토퍼</td>
              <td>2022.06.21</td>
            </tr>
            <tr class="review-row">
              <td>2</td>
              <td>그림이 참 예쁘네요.</td>
              <td>이민준</td>
              <td>2022.02.15</td>
            </tr>
          </table>
        </section>
      </div>
    </div>
  </main>
<%@ include file="layout/footer.jsp" %>