
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<t:insertTemplate template="/WEB-INF/jsp/template/template.jsp">
    <t:putAttribute name="body">
        <h1 class="ls-title-intro ls-ico-dashboard">${t['tit.dashboard']}</h1>
        <div class="ls-box ls-board-box">
            <header class="ls-info-header">
                <p class="ls-float-right ls-float-none-xs ls-small-info">Valido até <strong>01.05.2014</strong></p>
                <h2 class="ls-title-3">Consumo de envios</h2>
            </header>
            <div id="sending-stats" class="row">
                <div class="col-sm-6 col-md-3">
                    <div class="ls-box">
                        <h6 class="ls-title-4">Contratado</h6>
                        <span class="ls-board-data">
                            <strong>1 <small>milhão</small></strong>
                        </span>
                        <a href="#" class="ls-btn ls-btn-xs">Alterar plano</a>
                    </div>
                </div>

                <div class="col-sm-6 col-md-3">
                    <div class="ls-box">
                        <h6 class="ls-title-4">Avulso</h6>
                        <span class="ls-board-data">
                            <strong>0</strong>
                        </span>
                        <a href="#" class="ls-btn ls-btn-xs">Contratar mais envios</a>
                    </div>
                </div>

                <div class="col-sm-6 col-md-3">
                    <div class="ls-box">
                        <h6 class="ls-title-4">Distribuído</h6>
                        <span class="ls-board-data">
                            <strong>10.743</strong>
                        </span>
                    </div>
                </div>

                <div class="col-sm-6 col-md-3">
                    <div class="ls-box">
                        <h6 class="ls-title-4 color-default">Disponível</h6>
                        <span class="ls-board-data">
                            <strong class="ls-color-theme">81%</strong>
                            <small>989.257</small>
                        </span>
                    </div>
                </div>
            </div>

        </div>

        <div class="ls-box">
            <header class="ls-info-header">
                <h2 class="ls-title-3">Clientes que mais contrataram</h2>
                <a href="#" class="ls-btn ls-btn-sm">Ver mais relatórios</a>
            </header>

            <div id="panel-charts"></div>
        </div>

        <div class="row">

            <div class="col-md-6">
                <div class="ls-box">
                    <header class="ls-info-header">
                        <h2 class="ls-title-3">Clientes que mais contrataram</h2>
                        <a href="#" class="ls-btn ls-btn-sm">Ver todos</a>
                    </header>

                    <table class="ls-table">
                        <thead>
                        <th>Nome do cliente</th>
                        <th>Data de expiração</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td><a href="/locawebstyle/documentacao/exemplos/painel1/client">João da Silva</a> </td>
                                <td>10.04.2014</td>
                            </tr>
                            <tr>
                                <td><a href="/locawebstyle/documentacao/exemplos/painel1/client">João da Silva</a> </td>
                                <td>10.04.2014</td>
                            </tr>
                            <tr>
                                <td><a href="/locawebstyle/documentacao/exemplos/painel1/client">João da Silva</a> </td>
                                <td>10.04.2014</td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="ls-box">
                    <a href="#" class="ls-lnk-nav ls-ico-chevron-right">Política da conta</a>
                </div>

            </div>
            <div class="col-md-6">
                <div class="ls-box">
                    <header class="ls-info-header">
                        <h2 class="ls-title-3">Clientes bloqueados por bounce</h2>
                        <a href="/locawebstyle/documentacao/exemplos/painel1/clients" class="ls-btn ls-btn-sm">Ver todos</a>
                    </header>

                    <table class="ls-table">
                        <thead>
                        <th>Nome do cliente</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td><a href="/locawebstyle/documentacao/exemplos/painel1/client">João da Silva</a> </td>
                            </tr>
                            <tr>
                                <td><a href="/locawebstyle/documentacao/exemplos/painel1/client">João da Silva</a> </td>
                            </tr>
                            <tr>
                                <td><a href="/locawebstyle/documentacao/exemplos/painel1/client">João da Silva</a> </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="ls-box">
                    <a href="#" class="ls-lnk-nav ls-ico-chevron-right">Política de bounce</a>
                </div>
            </div>
        </div>

    <script src="<c:url value="/bower_components/highcharts/highcharts.js"/>" type="text/javascript"></script>
    <script type="text/javascript">
        $(function(){
            $("#panel-charts").highcharts({
                chart:{
                    type:"column"
                },
                title:{
                    text:"Agosto/2014"
                },
                xAxis:{
                    categories:[
                        "Joana",
                        "Marcela",
                        "Patricia",
                        "Diego"
                    ]
                },
                yAxis:{
                    min:0,
                    title:{
                        text:"Envios"
                    }
                },
                credits:{
                    text:"Nogsantos",
                    href:"http://www.fabricionogueira.eti.br",
                    style:{display:"none"}
                },
                colors:[
                    "#bdaa38",
                    "#aa4643 ",
                    "#89a54e"
                ],
                series:[{
                    name:"Total de envios contratados",
                    data:[25,50,20,13]
                }]
            });
        });
    </script>
</t:putAttribute>    
</t:insertTemplate>