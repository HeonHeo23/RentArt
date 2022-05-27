<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
<script src="/js/popup.js" type="text/javascript"></script>
<main class="discover-section">
    <div class="discover-wrapper">
      <h1 class="discover-header artist-header">
        후기
      </h1>
      <div class="detail-review">
        <table class="review-table">
          <c:forEach items="${list}" var="r">
          <tr class="review-row">
            <td class="review-num">${r.getRownum()}</td>
            <td class="review-product">${r.getpName()}</td>
            <td class="review-title"><a onclick="showPopUp('/review?no=${r.getrId()}&cmd=view')">${r.getrTitle()}</a></td>
            <td class="review-name">${r.getUserName()}</td>
            <td class="review-date"><fmt:formatDate pattern="yyyy.MM.dd" value="${r.getrRegDate()}" /></td>
          </tr>
          </c:forEach>
        </table>
      </div>
      <div class="pager-wrapper">
          <form class="discover-pager" action="/review">
            <c:set var="page" value="${(param.pg==null||param.pg=='')?1:param.pg}" />
          	<c:set var="startNum" value="${page-(page-1)%5}" />
	        <button type="submit" name="pg" value="${startNum-1}" class="pager-btn">◀</button>
            <c:forEach var="i" begin="0" end="4">
	          <input type="submit" name="pg" value="${startNum+i}" class="${(page==startNum+i)?'bg-blue':''} pager-btn" />
	        </c:forEach>
	        <button type="submit" name="pg" value="${startNum+5}" class="pager-btn">▶</button>
	      </form>
        </div>
    </div>
  </main>
<%@ include file="layout/footer.jsp" %>