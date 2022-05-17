<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/manage/header.jsp" %>
  <main class="manage-wrapper">
    <div class="manage-content">
      <form action="/manage/magazine" method="post">
        <header class=".manage-content-header">
          <div class="manage-buttons">
            <div class="manage-search">
              <select name="field">
                <option value="m_title" ${param.field.equals("r_title")?'selected':''}>제목</option>
              </select>
              <input type="text" name="query" value="${param.query}">
              <button type="submit" name="field" value="${param.field}">검색</button>
            </div>
            <a onclick="showPopUp('/manage/magazine/new')" class="manage-button button">매거진 등록</a>
          </div>
          <h1 class="manage-title">매거진 관리</h1>
          <p class="manage-title-sub">매거진을 추가, 수정, 삭제할 수 있습니다.</p>
        </header>
        <section class="manage-table-wrap">
          <table class="table-manage">
            <tr class="table-manage-th">
              <th>번호</th>
              <th>제목</th>
              <th>조회수</th>
              <th>등록일자</th>
              <th>수정일자</th>
            </tr>
            <c:forEach var="l" items="${list}">
            <tr class="table-manage-row">
              <td width="50px">${l.getId()}</td>
              <td><a onclick="showPopUp('/manage/magazine/detail?no=${l.getId()}')" class="table-link">${l.getTitle()}</a></td>
              <td>${l.getHits()}</td>
              <td width="130px"><fmt:formatDate value="${l.getRegDate()}" pattern="yyyy.MM.dd HH:mm" /></td>
              <td width="130px"><fmt:formatDate value="${l.getUpDate()}" pattern="yyyy.MM.dd HH:mm" /></td>
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