<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
  <main class="discover-section" onload="checkP()">
    <script type="text/javascript">
  window.onload = (event) => {
      checkP();
  };
  function checkP() {
    const ft = [<%String[] ft = request.getParameterValues("ft");
    if(ft!=null){
    for(String i:ft) {
    	out.print(i);
    	out.print(",");
    }}%>];
    const fp = [<%
    String[] fp = request.getParameterValues("fp");
    if(fp!=null){
    for(String i:fp) {
    	out.print(i);
    	out.print(",");
    }}%>];
    const fs = [<%
    String[] fs = request.getParameterValues("fs");
    if(fs!=null){
    for(String i:fs) {
    	out.print(i);
    	out.print(",");
    }}%>];
    ft.forEach((i) => checkF("filter-theme-"+i));
    fs.forEach((i) => checkF("filter-size-"+i));
    fp.forEach((i) => checkF("filter-price-"+i));
  }
  function checkF(p) {
    document.getElementById(p).checked = true;
  }
</script>
    <div class="discover-wrapper">
    <form action="/discover">
      <div class="discover-filters">
        <div class="filter-row">
          <header class="filter-header">
            테마
          </header>
          <div class="filter-buttons">
            <div class="filter-button">
              <input type="checkbox" name="ft" id="filter-theme-1" value="1">
              <label for="filter-theme-1">인물</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="ft" id="filter-theme-2" value="2">
              <label for="filter-theme-2">추상</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="ft" id="filter-theme-3" value="3">
              <label for="filter-theme-3">풍경</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="ft" id="filter-theme-4" value="4">
              <label for="filter-theme-4">정물</label>
            </div>
          </div>
        </div>
        <div class="filter-row">
          <header class="filter-header">
            사이즈
          </header>
          <div class="filter-buttons">
            <div class="filter-button">
              <input type="checkbox" name="fs" id="filter-size-1" value="1">
              <label for="filter-size-1">1-5호</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="fs" id="filter-size-2" value="2">
              <label for="filter-size-2">6-10호</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="fs" id="filter-size-3" value="3">
              <label for="filter-size-3">-20호</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="fs" id="filter-size-4" value="4">
              <label for="filter-size-4">-30호</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="fs" id="filter-size-5" value="5">
              <label for="filter-size-5">-40호</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="fs" id="filter-size-6" value="6">
              <label for="filter-size-6">-60호</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="fs" id="filter-size-7" value="7">
              <label for="filter-size-7">80호+</label>
            </div>
          </div>
        </div>
        <div class="filter-row">
          <header class="filter-header">
            가격대
          </header>
          <div class="filter-buttons">
            <div class="filter-button">
              <input type="checkbox" name="fp" id="filter-price-1" value="1">
              <label for="filter-price-1">-30만원</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="fp" id="filter-price-2" value="2">
              <label for="filter-price-2">30만원 - <br>50만원</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="fp" id="filter-price-3" value="3">
              <label for="filter-price-3">50만원 - <br>100만원</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="fp" id="filter-price-4" value="4">
              <label for="filter-price-4">100만원 - <br>200만원</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="fp" id="filter-price-5" value="5">
              <label for="filter-price-5">200만원 - <br>300만원</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="fp" id="filter-price-6" value="6">
              <label for="filter-price-6">300만원 - <br>500만원</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="fp" id="filter-price-7" value="7">
              <label for="filter-price-7">500만원 - <br>1000만원</label>
            </div>
            <div class="filter-button">
              <input type="checkbox" name="fp" id="filter-price-8" value="8">
              <label for="filter-price-8">1000만원+</label>
            </div>
          </div>
        </div>
        <div class="discover-middle">
          <div class="discover-count">
            총 <fmt:formatNumber type="number" value="${count}"/>점의 작품
          </div>
          <div class="middle-btns">
            <div class="discover-submit">
              <a href="/discover" class="submit-btn bg-brown">초기화</a>
            </div>
            <div class="discover-submit">
              <input type="submit" class="submit-btn" value="검색">
            </div>
          </div>
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
          <form class="discover-pager" action="/discover">
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
    </form>
    </div>
  </main>
<%@ include file="layout/footer.jsp" %>