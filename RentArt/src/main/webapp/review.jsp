<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
<script type="text/javascript">
function showPopUp(url) {
	let width = 1000;
	let height = 650;
	let left = (window.screen.width / 2) - (width / 2);
	let top = (window.screen.height / 4);
	
	let windowStatus = 'width='+width+', height='+height+', left='+left+', top='+top+', scrollbars=yes, status=yes, resizable=yes, titlebar=yes';
	
	window.open(url, "글쓰기", windowStatus);
}
</script>
<main class="discover-section">
    <div class="discover-wrapper">
      <h1 class="discover-header artist-header">
        후기
      </h1>
      <section class="detail-review">
        <table class="review-table">
          <c:forEach items="${list}" var="r">
          <tr class="review-row">
            <td class="review-num">${r.getRownum()}</td>
            <td class="review-title"><a onclick="showPopUp('/review?no=${r.getrId()}&cmd=view')">${r.getrTitle()}</a></td>
            <td class="review-name">${r.getUserName()}</td>
            <td class="review-date"><fmt:formatDate pattern="yyyy.MM.dd" value="${r.getrRegDate()}" /></td>
            <td class="review-product">${r.getpName()}</td>
          </tr>
          </c:forEach>
        </table>
      </section>
    </div>
  </main>
<%@ include file="layout/footer.jsp" %>