<%--
  Created by IntelliJ IDEA.
  User: Welisit
  Date: 2020/3/22
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
    </c:if>

    <c:forEach items="${requestScope.scopeList}" var="pageNum">
        <c:if test="${pageNum eq requestScope.page.pageNo}">
            ${pageNum}
        </c:if>
        <c:if test="${!(pageNum eq requestScope.page.pageNo)}">
            <a href="${requestScope.page.url}&pageNo=${pageNum}">${pageNum}</a>
        </c:if>

    </c:forEach>

    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
    <input type="button" id="searchPageBtn" value="确定">

    <script type="text/javascript">
        $(function(){
            // 跳到指定页码
            $("#searchPageBtn").click(function(){

                var pageNo = $("#pn_input").val();

                location.href = "${pageScope.baseUrl}${requestScope.page.url}&pageNo=" + pageNo;
            })
        })
    </script>

</div>
