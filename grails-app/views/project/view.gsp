<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 26/05/2015
  Time: 14:21
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name='layout' content='main'/>
</head>

<body>
<form>
    <table>
        <thead>
        <th colspan="2">${project.name}</th>
        </thead>
        <tbody>
        <tr class="suppressHover">
            <td class="label">Project code:</td>
            <td><strong>${project.code}</strong></td>
        </tr>
        <tr class="suppressHover">
            <td class="label">Tech lead:</td>
            <td><strong>${project?.techLead?.fullName}</strong></td>
        </tr>
        <tr class="suppressHover">
            <td class="label">Project manager:</td>
            <td><strong>${project?.projectManager?.fullName}</strong></td>
        </tr>
        <tr class="suppressHover">
            <td class="label">Delivery date:</td>
            <td><strong>${project.deliveryDate.format( 'dd-MM-yyyy' )}</strong></td>
        </tr>
        <tr class="suppressHover">
            <td class="label">Status:</td>
            <td><strong>${project.status.description}</strong></td>
        </tr>
        <tr class="suppressHover">
            <td class="label">Priority:</td>
            <td><strong>${project.priority}</strong></td>
        </tr>
        <tr class="suppressHover">
            <td></td>
            <td><g:actionSubmit value="Back" action="index"></g:actionSubmit></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>