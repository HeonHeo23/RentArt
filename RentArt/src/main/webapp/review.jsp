<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
<script src="/js/popup.js" type="text/javascript"></script>
  <main class="wrapper">
    <div class="container">
      <h1 class="page-title">후기</h1>
      <div class="page-subtitle">다른 이용자들이 작성한 후기를 만나보세요.</div>
      <div class="detail-review">
        <table class="review-table">
          <c:forEach items="${list}" var="r">
          <tr class="review-row">
            <td class="review-num">${r.getRownum()}</td>
            <td class="review-product">${r.getpName()}</td>
            <td class="review-title"><a class="link" onclick="showPopUp('/review?no=${r.getrId()}&cmd=view')">${r.getrTitle()}</a></td>
            <td class="review-name">${r.getUserName()}</td>
            <td class="review-date"><fmt:formatDate pattern="yyyy.MM.dd" value="${r.getrRegDate()}" /></td>
          </tr>
          </c:forEach>
        </table>
      </div>
      <form>
        <%@ include file="layout/pager.jsp" %>
	  </form>
    </div>
  </main>
<%@ include file="layout/footer.jsp" %>