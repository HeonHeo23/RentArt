<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/manage/header.jsp" %>
  <main class="manage-wrapper">
    <div class="manage-content">
      <form action="/manage/user" method="post">
        <header class=".manage-content-header">
          <div class="manage-buttons">
           <div class="manage-search">
              <select name="field">
                <option value="user_name" ${param.field.equals("user_name")?'selected':''}>이름</option>
                <option value="user_address" ${param.field.equals("user_address")?'selected':''}>주소</option>
              </select>
              <input type="text" name="query" value="${param.query}">
              <button type="submit" name="field" value="${param.field}">검색</button>
            </div>
          </div>
          <h1 class="manage-title">사용자 관리</h1>
          <p class="manage-title-sub">사용자 정보를 수정할 수 있습니다.</p>
        </header>
        <section class="manage-table-wrap">
          <table class="table-manage">
            <tr class="table-manage-th">
              <th>번호</th>
              <th>이름</th>
              <th>이메일</th>
              <th>주소</th>
              <th>등록일자</th>
            </tr>
            <c:forEach var="l" items="${list}">
            <tr class="table-manage-row">
              <td width="50px">${l.getKey()}</td>
              <td><a onclick="showPopUp('/manage/user/detail?no=${l.getKey()}')" class="table-link">${l.getName()}</a></td>
              <td>${l.getEmail()}</td>
              <td>${l.getAddress()}</td>
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