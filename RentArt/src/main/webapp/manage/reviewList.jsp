<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/manage/header.jsp" %>
  <main class="manage-wrapper">
    <div class="manage-content">
      <form action="/manage/review" method="post">
        <header class=".manage-content-header">
          <div class="manage-buttons">
            <div class="manage-search">
              <select name="field">
                <option value="r_title" ${param.field.equals("r_title")?'selected':''}>제목</option>
                <option value="user_name" ${param.field.equals("user_name")?'selected':''}>작성자</option>
                <option value="p_name" ${param.field.equals("p_name")?'selected':''}>작품명</option>
              </select>
              <input type="text" name="query" value="${param.query}">
              <button type="submit" name="field" value="${param.field}">검색</button>
            </div>
          </div>
          <h1 class="manage-title">리뷰 관리</h1>
          <p class="manage-title-sub">작품 리뷰를 수정, 삭제할 수 있습니다.</p>
        </header>
        <section class="manage-table-wrap">
          <table class="table-manage">
            <tr class="table-manage-th">
              <th>번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>작품이름</th>
              <th>등록일자</th>
              <th>수정일자</th>
            </tr>
            <c:forEach var="l" items="${list}">
            <tr class="table-manage-row">
              <td width="50px">${l.getrId()}</td>
              <td><a onclick="showPopUp('/manage/review/detail?no=${l.getrId()}')" class="table-link">${l.getrTitle()}</a></td>
              <td><a href="/manage/user?field=user_name&query=${l.getUserName()}" class="table-link">${l.getUserName()} (${l.getUserKey()})</a></td>
              <td><a href="/manage/review?field=p_name&query=${l.getpName()}" class="table-link">${l.getpName()}</a> <span onclick="showPopUp('/manage/detail?no=${l.getpId()}')" class="table-link">(${l.getpId()})</span></td>
              <td width="130px"><fmt:formatDate value="${l.getrRegDate()}" pattern="yyyy.MM.dd HH:mm" /></td>
              <td width="130px"><fmt:formatDate value="${l.getrUpDate()}" pattern="yyyy.MM.dd HH:mm" /></td>
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