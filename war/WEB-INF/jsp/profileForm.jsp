<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="profile==null || profile.id == null">
	<s:set name="title" value="%{'Add new profile'}"/>
</s:if>
<s:else>
	<s:set name="title" value="%{'Update profile'}"/>
</s:else>

<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td { white-space:nowrap; }</style>
    <title><s:property value="#title"/></title>
</head>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:property value="#title"/></h1>
<s:actionerror />
<s:actionmessage />
<s:form action="crud!save.action" method="post">
    <s:textfield name="profile.name" value="%{profile.name}" label="%{getText('label.name')}" size="40"/>
    <s:textfield name="profile.email" value="%{profile.email}" label="%{getText('label.email')}" size="40"/>
    <s:hidden name="profile.id" value="%{profile.id}"/>
    <s:submit value="%{getText('button.label.submit')}"/>
    <s:submit value="%{getText('button.label.cancel')}" name="redirect-action:index"/>
</s:form>
</body>
</html>