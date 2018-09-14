<%-- 
    Document   : footer
    Created on : Dec 5, 2014, 11:45:53 AM
    Author     : nogsantos
--%>

<footer class="ls-footer" role="contentinfo">
    <nav class="ls-footer-menu">
        <h2 class="ls-title-footer">${t['tit.technical_support']}</h2>
        <ul class="ls-footer-list">
            <li>
                <a href="#" target="_blank" class="bg-customer-support">
                    <span class="visible-lg">${t['tit.support']}</span>
                </a>
            </li>
            <li>
                <a href="#" target="_blank" class="bg-statusblog">
                    <span class="visible-lg">${t['tit.blog']}</span>
                </a>
            </li>
        </ul>
    </nav>
    <div class="ls-footer-info">
        <span class="last-access ls-ico-screen"><strong>${t['tit.last_access']}: </strong>${last_access}</span>        
        <p class="ls-copy-right">Copyright &copy; ${current_year} ${t['sys.name']}.</p>
    </div>
</footer>