<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
  <main class="discover-section">
    <div class="discover-wrapper">
      <header>
        <h1>작가 목록</h1>
        <div class="artist-middle">
          총 ${count}명의 작가
        </div>
      </header>
      <div class="discover-views">
        <c:forEach var="l" items="${list}">
        <div class="card">
          <a class="card-img card-img-big" href="/artist?no=${l.getArtistId()}">
            <div class="card-img-mask">
              <img src="/img/product/${l.getpImg()}" alt="">
            </div>
          </a>
          <div class="card-info">
            <div class="card-text">
              <h4 class="card-title-big">${l.getArtistName()}</h4>
            </div>
            <div class="card-number">
              <div class="card-number-row">
                작품
              </div>
              <div class="card-number-row">
                ${l.getCountProduct()}
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
      </div>
      <div class="pager-wrapper">
        <form class="discover-pager" action="/artist">
          <c:set var="page" value="${(param.pg==null||param.pg=='')?1:param.pg}" />
          <c:set var="startNum" value="${page-(page-1)%5}" />
        <button type="submit" name="pg" value="${startNum-1}" class="pager-btn">◀</button>
          <c:forEach var="i" begin="0" end="4">
          <input type="submit" name="pg" value="${startNum+i}" class="${(page==startNum+i)?'bg-blue':''} pager-btn" />
        </c:forEach>
        <button type="submit" name="pg" value="${startNum+5}" class="pager-btn">▶</button>
      </form>
      </div>
    </div>
  </main>
<%@ include file="layout/footer.jsp" %>