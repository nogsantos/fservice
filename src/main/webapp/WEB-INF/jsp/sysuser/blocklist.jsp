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
        <h1 class="ls-title-intro ls-ico-users">${t['tit.block.users']} <small>${t['tit.list.block.users']}</small> </h1>
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
                        <li><a href="${linkTo[SysuserController].index}"><i class="fa fa-list"></i> ${t['tit.list']}</a></li>
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
            <c:when test="${not empty blockusers}">
                <div class="panel panel-default">
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th class="text-center">${t['tit.name']}</th>
                                <th class="text-center">${t['tit.email']}</th>
                                <th class="text-center">${t['tit.login']}</th>
                                <th class="text-center">${t['tit.date_update']}</th>
                                <th class="text-center">${t['tit.date_block']}</th>
                                <th class="text-center">${t['tit.actions']}</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${blockusers}" var="sysuser">
                                <tr>
                                    <td>${sysuser.name}</td>
                                    <td>${sysuser.emails}</td>
                                    <td>${sysuser.login}</td>
                                    <td>${l[sysuser.dtUpdate].pattern("dd/MM/yyyy 'às' H'h'mm'm'")}</td>
                                    <td>${l[sysuser.dtBlock].pattern("dd/MM/yyyy 'às' H'h'mm'm'")}</td>
                                    <td class="text-center"><a href="${linkTo[SysuserController].release}${sysuser.id}" class="btn btn-success" role="button" title="${t['tit.release']}" alt="${t['tit.release']}" ><i class="fa fa-unlock"></i></a></td>                                    
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
    </t:putAttribute>
</t:insertTemplate>