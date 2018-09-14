<%-- 
    Document   : notificacoes
    Created on : Dec 5, 2014, 11:47:10 AM
    Author     : nogsantos
--%>
<aside class="ls-notification">
    <nav class="ls-notification-list" id="ls-notification-curtain">
        <h3 class="ls-title-2">${t['tit.notification']}</h3>
        <ul>
            <c:forEach var="i" begin="1" end="${numNot}">
                <li class="ls-dismissable">
                    <a href="#">${notification}</a>
                    <a href="#" data-ls-module="dismiss" class="ls-ico-close ls-close-notification"></a>
                </li>
            </c:forEach>
        </ul>
        <p class="ls-no-notification-message">N&atilde;o h&aacute; notifica&ccedil;&otilde;es.</p>
    </nav>
    <!--feedback-->
    <nav class="ls-notification-list" id="ls-help-curtain">
        <h3 class="ls-title-2">Feedback</h3>
        <ul>
            <li><a href="#">> ut asperiores dignissimos error aut rerum</a></li>
            <li><a href="#">> delectus fugiat id animi aspernatur placeat</a></li>
        </ul>
    </nav>
    <!--ajuda-->
    <nav class="ls-notification-list" id="ls-feedback-curtain">
        <h3 class="ls-title-2">Ajuda</h3>
        <ul>
            <li class="ls-txt-center hidden-xs">
                <a href="#" class="ls-btn-dark ls-btn-tour">Fazer um Tour</a>
            </li>
            <li><a href="#">> Guia</a></li>
            <li><a href="#">> Wiki</a></li>
        </ul>
    </nav>
</aside>