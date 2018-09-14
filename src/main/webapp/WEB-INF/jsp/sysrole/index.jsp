<%-- 
    Document   : main
    Created on : Dec 4, 2014, 8:13:03 PM
    Author     : nogsantos
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<t:insertTemplate template="/WEB-INF/jsp/template/template.jsp">
    <t:putAttribute name="body">
        <h1 class="ls-title-intro ls-ico-book">${t['tit.role']} <small>${t['tit.list']}</small> </h1>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <span class="navbar-brand">${t['tit.options']}&nbsp;<i class="fa fa-angle-double-right"></i></span>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="${linkTo[SysroleController].form}"><i class="fa fa-file-o"></i> ${t['tit.new']}</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <c:if test="${not empty return_message}">
            <div class="alert alert-info" role="info">
                <button type="button" class="close" data-dismiss="alert">
                    <span aria-hidden="true">&times;</span><span class="sr-only">${t['tit.close']}</span>
                </button>
                ${t[return_message]}
            </div>
        </c:if>
        <c:choose>
            <c:when test="${not empty roles}">
                <div class="panel panel-default appTable">
                    <table id="sysRoleTable" class="display" cellspacing="0" width="100%">
                        <thead>
                            <tr>
                                <th class="text-center">${t['tit.name']}</th>
                                <th class="text-center">${t['tit.date_cadastre']}</th>
                                <th class="text-center">${t['tit.date_update']}</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${roles}" var="role">
                                <tr>
                                    <td>${role.name}</td>
                                    <td class="text-center">${l[role.dtCadastre].pattern("dd/MM/yyyy 'às' H'h'mm'm'")}</td>
                                    <td class="text-center">${l[role.dtUpdate].pattern("dd/MM/yyyy 'às' H'h'mm'm'")}</td>
                                    <td class="text-center"><a href="${linkTo[SysroleController].update}${role.id}" class="btn btn-default ls-tooltip-top" role="button" aria-label="${t['tit.edit']}" alt="${t['tit.edit']}" ><i class="fa fa-edit"></i></a></td>
                                    <td class="text-center"><a href="${linkTo[SysroleController].block}${role.id}" class="btn btn-default ls-tooltip-top" role="button" aria-label="${t['tit.block']}" alt="${t['tit.block']}" ><i class="fa fa-lock"></i></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:when>
            <c:otherwise>
                <div class="jumbotron text-center">
                    <div class="container">
                        <h3>${t['list.empty']}</h3>
                    </div>
                </div>					
            </c:otherwise>
        </c:choose>
        <script src="<c:url value="/js/administration/sysrole/sysroleController.js"/>" type="text/javascript"></script>  
    </t:putAttribute>
</t:insertTemplate>