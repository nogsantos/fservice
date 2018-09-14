<%-- 
    Document   : 404
    Created on : Dec 19, 2014, 4:52:03 PM
    Author     : nogsantos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<c:choose>
    <c:when test="${sysuser_session.logged == true}">
        <t:insertTemplate template="/WEB-INF/jsp/template/template.jsp">
            <t:putAttribute name="body">
                <h1 class="ls-title-intro ls-ico-cog">500 <small>${t['tit.system.fail']}</small></h1>

            </t:putAttribute>
        </t:insertTemplate>
    </c:when>
    <c:otherwise>
        <%@ include file="/WEB-INF/jsp/template/head.jsp" %>
        <body>
            <div class="container">
                <div class="page-header">
                    <p>
                        <h1 class="ls-ico-mobile">
                            ${t['sys.name']}
                        </h1>
                    </p>
                    <p>
                        <h1 class="ls-ico-cog text-center">500 <small>${t['tit.system.fail']}</small></h1>
                    </p>
                </div>
            </div>
        </body>
    </html>
    </c:otherwise>
</c:choose>