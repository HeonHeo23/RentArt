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
                <option value="m_title" ${param.field.equals("r_title")?'selected':''}>제목</option>
                <option value="m_id" ${param.field.equals("m_id")?'selected':''}>매거진ID</option>
              </select>
              <input type="text" name="query" value="${param.query}">
              <button type="submit" name="field" value="${param.field}">검색</button>
            </div>
            <a onclick="showPopUp('/manage/magazine/new')" class="manage-btn btn">매거진 등록</a>
          </div>
          <h1 class="manage-title"><a href="?" class="link">매거진 관리</a></h1>
          <p class="manage-subtitle">매거진을 추가, 수정, 삭제할 수 있습니다.</p>
        </header>
        <section class="manage-table-wrap">
          <table class="manage-table">
            <tr class="manage-table-th">
              <th>번호</th>
              <th>제목</th>
              <th>조회수</th>
              <th>등록일자</th>
              <th>수정일자</th>
            </tr>
            <c:forEach var="l" items="${list}">
            <tr class="manage-table-row">
              <td width="50px">${l.getId()}</td>
              <td><a onclick="showPopUp('/manage/magazine/detail?no=${l.getId()}')" class="link">${l.getTitle()}</a></td>
              <td width="50px">${l.getHits()}</td>
              <td width="130px"><fmt:formatDate value="${l.getRegDate()}" pattern="yyyy.MM.dd HH:mm" /></td>
              <td width="130px"><fmt:formatDate value="${l.getUpDate()}" pattern="yyyy.MM.dd HH:mm" /></td>
            </tr>
            </c:forEach>
          </table>
        </section>
      <%@ include file="/layout/pager.jsp" %>
      </form>
    </div>
  </main>
<%@ include file="/layout/manage/footer.jsp" %> 