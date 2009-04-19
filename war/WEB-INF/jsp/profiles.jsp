<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <title><s:text name="label.profiles"/></title>
</head>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:text name="label.profiles"/></h1>
<s:url id="url" action="crud!input" />
<a href="<s:property value="#url"/>">Add New Profile</a>
<br/><br/>
<table class="borderAll">
    <tr>
        <th><s:text name="label.name"/></th>
        <th><s:text name="label.email"/></th>
        <th>&nbsp;</th>
    </tr>
    <s:iterator value="profiles" status="status">
        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
            <td class="nowrap"><s:property value="name"/></td>
            <td class="nowrap"><s:property value="email"/></td>
            <td class="nowrap">
                <s:url action="crud!input" id="url">
                    <s:param name="profile.id" value="id"/>
                </s:url>
                <a href="<s:property value="#url"/>">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <s:url action="crud!delete" id="url">
                    <s:param name="profile.id" value="id"/>
                </s:url>
                <a href="<s:property value="#url"/>">Delete</a>
            </td>
        </tr>
    </s:iterator>
    </table>
</body>
</html>