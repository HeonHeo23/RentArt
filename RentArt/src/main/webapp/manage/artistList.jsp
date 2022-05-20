<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/manage/header.jsp" %>
  <main class="manage-wrapper">
    <div class="manage-content">
      <form action="/manage/artist" method="post">
        <header class=".manage-content-header">
          <div class="manage-buttons">
            <div class="manage-search">
              <select name="field">
                <option value="artist_name" ${param.field.equals("artist_name")?'selected':''}>작가명</option>
                <option value="a.artist_id" ${param.field.equals("a.artist_id")?'selected':''}>작가ID</option>
              </select>
              <input type="text" name="query" value="${param.query}">
              <button type="submit" name="field" value="${param.field}">검색</button>
            </div>
            <a onclick="showPopUp('/manage/artist/new')" class="manage-button button">작가 등록</a>
          </div>
          <h1 class="manage-title">작가 관리</h1>
          <p class="manage-title-sub">작가 정보를 추가, 수정, 삭제할 수 있습니다.</p>
        </header>
        <section class="manage-table-wrap">
          <table class="table-manage">
            <tr class="table-manage-th">
              <th>번호</th>
              <th>이름</th>
              <th>작품 개수(클릭시 목록으로)</th>
              <th>공지 개수</th>
              <th>등록일자</th>
              <th>수정일자</th>
            </tr>
            <c:forEach var="l" items="${list}">
            <tr class="table-manage-row">
              <td width="50px">${l.getArtistId()}</td>
              <td><a onclick="showPopUp('/manage/artist/detail?no=${l.getArtistId()}')" class="table-link">${l.getName()}</a></td>
              <td width="100px">
                <a href="/manage/product?field=artist_id&query=${l.getArtistId()}" class="table-link">${l.getCountProduct()} 개</a>
              </td>
              <td width="100px">${l.getCountNotice()}개</td>
              <td width="200px"><fmt:formatDate value="${l.getRegDate()}" pattern="yyyy.MM.dd HH:mm" /></td>
              <td width="200px"><fmt:formatDate value="${l.getUpDate()}" pattern="yyyy.MM.dd HH:mm" /></td>
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