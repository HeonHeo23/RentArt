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
                <option value="user_name" ${param.field.equals("user_name")?'selected':''}>이름</option>
                <option value="user_address" ${param.field.equals("user_address")?'selected':''}>주소</option>
                <option value="user_key" ${param.field.equals("user_key")?'selected':''}>유저Key</option>
              </select>
              <input type="text" name="query" value="${param.query}">
              <button type="submit" name="field" value="${param.field}">검색</button>
            </div>
          </div>
          <h1 class="manage-title"><a href="?" class="link">사용자 관리</a></h1>
          <p class="manage-subtitle">사용자 정보를 수정할 수 있습니다.</p>
        </header>
        <section class="manage-table-wrap">
          <table class="manage-table">
            <tr class="manage-table-th">
              <th>번호</th>
              <th>이름</th>
              <th>이메일</th>
              <th>주소</th>
              <th>리뷰</th>
              <th>찜</th>
              <th>등록일자</th>
              <th>수정일자</th>
            </tr>
            <c:forEach var="l" items="${list}">
            <tr class="manage-table-row">
              <td width="50px">${l.getKey()}</td>
              <td><a onclick="showPopUp('/manage/user/detail?no=${l.getKey()}')" class="link">${l.getName()}</a></td>
              <td>${l.getEmail()}</td>
              <td>${l.getAddress()}</td>
              <td width="50px"><a href="/manage/review?field=user_key&query=${l.getKey()}" class="link">${l.getCountReview()}</a></td>
              <td width="50px">${l.getCountFavorite()}</td>
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