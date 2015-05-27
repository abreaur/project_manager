<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 27/05/2015
  Time: 16:31
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
                <th>Delete confirmation</th>
            </thead>
            <tbody>
                <tr class="suppressHover">
                    <td>
                        Are you sure you want to delete project: <strong>${name} ?</strong>
                    </td>
                </tr>

                <tr class="suppressHover">
                    <td>
                        <g:actionSubmit value="Back" action="index"></g:actionSubmit>
                        <g:actionSubmit value="Delete" action="delete" params="[id: id]"></g:actionSubmit>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>