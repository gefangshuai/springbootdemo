<#ftl strip_whitespace=true>
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

<#--显示当前登录用户的名字，为空则显示guestName-->
<#macro principal guestName="游客">
    <#if Session.shiroUser?exists>
    ${Session.shiroUser.principal}
    <#else>
    游客
    </#if>
</#macro>

<#--当前用户有角色显示的内容-->
<#macro hasRole role>
    <#if Session.shiroUser?exists && Session.shiroUser.roles?seq_contains(role)>
        <#nested>
    </#if>
</#macro>

<#--没有角色显示的内容-->
<#macro lacksRole role>
    <#if !Session.shiroUser?exists || !Session.shiroUser.roles?seq_contains(role)>
        <#nested>
    </#if>
</#macro>

<#--有权限显示的内容-->
<#macro hasPermission permission>
    <#if Session.shiroUser?exists && Session.shiroUser.permissions?seq_contains(permission)>
        <#nested>
    </#if>
</#macro>

<#--没有权限显示的内容-->
<#macro lacksPermission permission>
    <#if !Session.shiroUser?exists || !Session.shiroUser.permissions?seq_contains(permission)>
        <#nested>
    </#if>
</#macro>