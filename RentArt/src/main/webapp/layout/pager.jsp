<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <div class="pager-wrapper">
        <div class="pager">
          <c:set var="page" value="${(param.pg==null||param.pg=='')?1:param.pg}" />
          <c:set var="startNum" value="${page-(page-1)%5}" />
	      <button type="submit" name="pg" value="${startNum-1}" class="btn pager-btn">◀</button>
          <c:forEach var="i" begin="0" end="4">
	        <input type="submit" name="pg" value="${startNum+i}" class="${(page==startNum+i)?'bg-blue':''} btn pager-btn" />
	      </c:forEach>
	      <button type="submit" name="pg" value="${startNum+5}" class="btn pager-btn">▶</button>
	    </div>
      </div>