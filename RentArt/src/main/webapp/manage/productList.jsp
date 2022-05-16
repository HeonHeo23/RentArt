<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/manage/header.jsp" %>
  <main class="manage-wrapper">
    <div class="manage-content">
      <form action="/manage/product" method="post">
        <header class=".manage-content-header">
          <div class="manage-buttons">
            <div class="manage-search">
              <select name="field">
                <option value="p_name" ${param.field.equals("p_name")?'selected':''}>제목</option>
                <option value="artist_name" ${param.field.equals("artist_name")?'selected':''}>작가명</option>
              </select>
              <input type="text" name="query" value="${param.query}">
              <button type="submit" name="field" value="${param.field}">검색</button>
            </div>
            <a onclick="showPopUp('/manage/product/new')" class="manage-button button">작품 등록</a>
            <button type="submit" class="manage-button button" name="cmd" value="rent">대여 변경</button>
          </div>
          <h1 class="manage-title">작품 관리</h1>
          <p class="manage-title-sub">작품을 등록, 수정, 삭제 할 수 있습니다.</p>
        </header>
        <section class="manage-table-wrap">
          <table class="table-manage">
            <tr class="table-manage-th">
              <th>번호</th>
              <th>제목</th>
              <th>작가</th>
              <th>크기</th>
              <th>가격</th>
              <th>테마</th>
              <th>제작년도</th>
              <th>등록일자</th>
              <th>수정일자</th>
              <th>찜</th>
              <th>대여여부</th>
            </tr>
            <c:forEach var="l" items="${list}">
            <tr class="table-manage-row">
              <c:set var="id" value="${l.getpId()}"/>
              <td width="50px">${id}<input type="hidden" name="ids" value="${id}"></td>
              <td><a onclick="showPopUp('/manage/detail?no=${id}')" class="table-link">${l.getpName()}</a></td>
              <td>${l.getArtistName()} (${l.getArtistId()})</td>
              <td>${l.getSize()}호</td>
              <td width="90px">&#8361;<fmt:formatNumber value="${l.getPrice()}" /> </td>
              <td>${l.getThemeString()}</td>
              <td width="60px">${l.getYear()}</td>
              <td width="130px"><fmt:formatDate value="${l.getRegDate()}" pattern="yyyy.MM.dd HH:mm" /></td>
              <td width="130px"><fmt:formatDate value="${l.getUpDate()}" pattern="yyyy.MM.dd HH:mm" /></td>
              <td>${l.getFavorite()}</td>
              <td width="60px" align="center"><input type="checkbox" name="rents" value="${id}" ${l.isRent() ? 'checked' : ''}></td>
            </tr>
            </c:forEach>
          </table>
        </section>
      </form>
      <div class="pager-wrapper">
        <div class="manage-pager">
          <c:set var="page" value="${(param.pg==null||param.pg=='')?1:param.pg}" />
          <c:set var="startNum" value="${page-(page-1)%5}" />
          <a href="?pg=${startNum-1}&field=${param.field}&query=${param.query}" class="pager-btn">◀</a>
          <c:forEach var="i" begin="0" end="4">
          <a href="?pg=${startNum+i}&field=${param.field}&query=${param.query}" class="${(page==startNum+i)?'bg-blue':''} pager-btn">${startNum+i}</a>
          </c:forEach>
          <a href="?pg=${startNum+5}&field=${param.field}&query=${param.query}" class="pager-btn">▶</a>
        </div>
      </div>
    </div>
  </main>
<%@ include file="/layout/manage/footer.jsp" %> 