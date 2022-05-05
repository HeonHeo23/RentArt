<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
  <main class="discover-section">
    <div class="discover-wrapper">
      <h1 class="discover-header">${userName}님의 찜 목록</h1>
      <div class="discover-middle">
        <div class="discover-count">
          총 <fmt:formatNumber type="number" value="${count}"/>점의 작품
        </div>
      </div>
      <div>
        <div class="discover-views">
        <c:forEach var="row" begin="1" end="${ls}">
          <div class="views-row">
          <c:forEach var="l" items="${list}" begin="${(row-1)*4}" end="${(row-1)*4+3}">
            <div class="card">
              <a class="card-img" href="/detail?no=${l.getpId()}">
                <div class="card-img-mask">
                  <img src="/img/product/${l.getpImg()}" alt="">
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
        </c:forEach>
        </div>
        <div class="discover-pager-wrapper">
          <div class="discover-pager">
            <c:set var="page" value="${(param.pg==null||param.pg=='')?1:param.pg}" />
            <c:set var="startNum" value="${page-(page-1)%5}" />
          <a href="?pg=${startNum-1}" class="pager-btn">◀</a>
            <c:forEach var="i" begin="0" end="4">
            <a href="?pg=${startNum+i}" class="${(page==startNum+i)?'bg-blue':''} pager-btn">${startNum+i}</a>
          </c:forEach>
          <a href="?pg=${startNum+5}" class="pager-btn">▶</a>
          </div>
        </div>
      </div>
    </div>
  </main>
<%@ include file="layout/footer.jsp" %>