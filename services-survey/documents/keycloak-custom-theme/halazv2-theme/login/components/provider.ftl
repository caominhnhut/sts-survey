<#import "./socials.ftl" as socials>

<#macro kw>
    <div class="separate pt-4">${msg("identity-provider-login-label")}</div>
    <!--<p class="para">${msg("socialLoginAlternate")}</p>-->
    <div id="social-providers">
        <#list social.providers as p>
            <input class="social-link-style" type="button" onclick="location.href='${p.loginUrl}';" value="${p.displayName}"/>
        </#list>
    </div>
</#macro>
