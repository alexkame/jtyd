<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
      <table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
			    <th>文章标题</th>
				<th>文章地址</th>
				<th>公众号名称</th>
				<th>公众号</th>
				<!-- <th>文章内容</th> -->
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${jtydWeixinArticleList}" var="jtydWeixinArticle">
			<tr>
			     <td>
					<input type="radio" name="weixinArticle" value="${jtydWeixinArticle.id}" />
					<span id="${jtydWeixinArticle.id}">${jtydWeixinArticle.articleName}</span>
				</td>
				<td>
					 <c:set var="articleUrl" value="${jtydWeixinArticle.articleUrl}"></c:set>     
					 <c:choose>  
					    <c:when test="${fn:length(articleUrl) > 90}">  
					        <a href="${jtydWeixinArticle.articleUrl}" target="_blank" title="${jtydWeixinArticle.articleUrl}"><c:out value="${fn:substring(articleUrl, 0, 90)}......" />  </a>
					    </c:when>  
					   <c:otherwise>  
					      <c:out value="${articleUrl}" />  
					    </c:otherwise>  
					</c:choose> 
				</td>
				<td>
				
					${jtydWeixinArticle.weixinName}
				</td>
				<td>
					${jtydWeixinArticle.weixinCode}
				</td>
				
				<%-- <td>
					 <c:set var="articleContent" value="${jtydWeixinArticle.articleContent}"></c:set>     
					 <c:choose>  
					    <c:when test="${fn:length(articleContent) > 50}">  
					        <c:out value="${fn:substring(articleContent, 0, 50)}......" />  
					    </c:when>  
					   <c:otherwise>  
					      <c:out value="${articleContent}" />  
					    </c:otherwise>  
					</c:choose> 
				</td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
 