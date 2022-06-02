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
                <option value="r_title" ${param.field.equals("r_title")?'selected':''}>제목</option>
                <option value="user_name" ${param.field.equals("user_name")?'selected':''}>작성자</option>
                <option value="user_key" ${param.field.equals("user_key")?'selected':''}>작성자ID</option>
                <option value="p_name" ${param.field.equals("p_name")?'selected':''}>작품명</option>
                <option value="p_id" ${param.field.equals("p_id")?'selected':''}>작품ID</option>
              </select>
              <input type="text" name="query" value="${param.query}">
              <button type="submit" name="field" value="${param.field}">검색</button>
            </div>
          </div>
          <h1 class="manage-title"><a href="?" class="link">리뷰 관리</a></h1>
          <p class="manage-subtitle">작품 리뷰를 수정, 삭제할 수 있습니다.</p>
        </header>
        <section class="manage-table-wrap">
          <table class="manage-table">
            <tr class="manage-table-th">
              <th>번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>작품이름</th>
              <th>조회수</th>
              <th>등록일자</th>
              <th>수정일자</th>
            </tr>
            <c:forEach var="l" items="${list}">
            <tr class="manage-table-row">
              <td width="50px">${l.getrId()}</td>
              <td><a onclick="showPopUp('/manage/review/detail?no=${l.getrId()}')" class="link">${l.getrTitle()}</a></td>
              <td><a href="/manage/review?field=user_key&query=${l.getUserKey()}" class="link">${l.getUserName()}</a> <span onclick="showPopUp('/manage/user/detail?no=${l.getUserKey()}')" class="link">(${l.getUserKey()})</span></td>
              <td><a href="/manage/review?field=p_name&query=${l.getpName()}" class="link">${l.getpName()}</a> <span onclick="showPopUp('/manage/detail?no=${l.getpId()}')" class="link">(${l.getpId()})</span></td>
              <td width="50px">${l.getrHits()}</td>
              <td width="130px"><fmt:formatDate value="${l.getrRegDate()}" pattern="yyyy.MM.dd HH:mm" /></td>
              <td width="130px"><fmt:formatDate value="${l.getrUpDate()}" pattern="yyyy.MM.dd HH:mm" /></td>
            </tr>
            </c:forEach>
          </table>
        </section>
      <%@ include file="/layout/pager.jsp" %>
      </form>
    </div>
  </main>
<%@ include file="/layout/manage/footer.jsp" %> 