<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 25/05/2015
  Time: 19:37
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name='layout' content='main'/>
</head>
<body>
<table>
    <thead>
        <th>Name</th>
        <th>Code</th>
        <th>Manager</th>
        <th>Delivery date</th>
        <th>Status</th>
        <th>Priority</th>
        <th></th>
        <th></th>
    </thead>
    <g:each var="p" in="${projects}">
        <tr onclick='document.location = "<g:createLink action='view' id='${p.id}'/>"'>
            <td>${p.name}</td>
            <td class="numericCell">${p.code}</td>
            <td>${p.projectManager.fullName}</td>
            <td class="numericCell">${p.deliveryDate.format( 'dd-MM-yyyy' )}</td>
            <td>${p.status.description}</td>
            <td class="numericCell">${p.priority}</td>
            <td><g:link action="edit" params="[id: p.id]"><asset:image src="skin/database_edit.png"></asset:image></g:link></td>
            <td><g:link action="goToDelete" params="[id: p.id, name: p.name]"><asset:image src="skin/database_delete.png"></asset:image></g:link></td>
        </tr>
    </g:each>
    <tr class="suppressHover">
        <td colspan="8">
            <form>
                <g:actionSubmit value="Add" action="add"></g:actionSubmit>
            </form>
        </td>
    </tr>
</table>

</body>
</html>