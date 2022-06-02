<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/manage/header.jsp" %>
  <main class="manage-wrap">
    <div class="manage-container">
      <form method="post">
        <header class="manage-content-header">
          <div class="manage-btn-group">
            <div class="manage-search">
              <select name="field">
                <option value="p_name" ${param.field.equals("p_name")?'selected':''}>제목</option>
                <option value="p_id" ${param.field.equals("p_id")?'selected':''}>작품ID</option>
                <option value="artist_name" ${param.field.equals("artist_name")?'selected':''}>작가명</option>
                <option value="artist_id" ${param.field.equals("artist_id")?'selected':''}>작가ID</option>
              </select>
              <input type="text" name="query" value="${param.query}">
              <button type="submit" name="field" value="${param.field}">검색</button>
            </div>
            <a onclick="showPopUp('/manage/product/new')" class="manage-btn btn">작품 등록</a>
            <button type="submit" class="manage-btn btn" name="cmd" value="rent">대여 변경</button>
          </div>
          <h1 class="manage-title"><a href="?" class="link">작품 관리</a></h1>
          <p class="manage-subtitle">작품을 등록, 수정, 삭제 할 수 있습니다.</p>
        </header>
        <section class="manage-table-wrap">
          <table class="manage-table">
            <tr class="manage-table-th">
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
              <th>조회수</th>
              <th>대여여부</th>
            </tr>
            <c:forEach var="l" items="${list}">
            <tr class="manage-table-row">
              <c:set var="id" value="${l.getpId()}"/>
              <td width="50px">${id}<input type="hidden" name="ids" value="${id}"></td>
              <td><a onclick="showPopUp('/manage/detail?no=${id}')" class="link">${l.getpName()}</a></td>
              <td><a href="/manage/product?field=artist_id&query=${l.getArtistId()}" class="link">${l.getArtistName()}</a> <a onclick="showPopUp('/manage/artist/detail?no=${l.getArtistId()}')" class="link">(${l.getArtistId()})</a></td>
              <td>${l.getSize()}호</td>
              <td width="90px">&#8361;<fmt:formatNumber value="${l.getPrice()}" /> </td>
              <td>${l.getThemeString()}</td>
              <td width="60px">${l.getYear()}</td>
              <td width="130px"><fmt:formatDate value="${l.getRegDate()}" pattern="yyyy.MM.dd HH:mm" /></td>
              <td width="130px"><fmt:formatDate value="${l.getUpDate()}" pattern="yyyy.MM.dd HH:mm" /></td>
              <td width="50px">${l.getFavorite()}</td>
              <td width="50px">${l.getHits()}</td>
              <td width="60px" align="center"><input type="checkbox" name="rents" value="${id}" ${l.isRent() ? 'checked' : ''}></td>
            </tr>
            </c:forEach>
          </table>
        </section>
        <%@ include file="/layout/pager.jsp" %>
      </form>
    </div>
  </main>
<%@ include file="/layout/manage/footer.jsp" %> 