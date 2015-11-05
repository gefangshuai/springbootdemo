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

<#--自定义根据角色判断标签-->
<#macro hasRoles role>
    <#if Session.shiroUser?exists && Session.shiroUser.roles?seq_contains(role)>
        <#nested>
    </#if>
</#macro>

<#--自定义根据权限判断标签-->
<#macro hasPermissions permission>
    <#if Session.shiroUser?exists && Session.shiroUser.permissions?seq_contains(permission)>
        <#nested>
    </#if>
</#macro>