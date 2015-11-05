<#--需配合 Session.shiroUser 使用-->
<#--
    用户没有登录时，显示的信息
-->
<#macro guest>
    <#if !Session.shiroUser?exists>
        <#nested>
    </#if>
</#macro>

<#--
    用户登录时，显示的信息
-->
<#macro user>
    <#if Session.shiroUser?exists>
        <#nested >
    </#if>
</#macro>

<#macro principal>
    <#if Session.shiroUser?exists>
    ${Session.shiroUser.principal}
    </#if>
</#macro>