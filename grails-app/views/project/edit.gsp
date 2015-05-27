<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 25/05/2015
  Time: 20:20
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
                <th>${project.id != null ? "Edit project" : "Add project"}</th>
                <th></th>
            </thead>
            <tbody>
                <tr>
                    <td class="label">Project name:</td>
                    <td><g:textField name="name" value="${project.name}"></g:textField></td>
                </tr>
                <tr>
                    <td class="label">Project code:</td>
                    <td><g:textField name="code" value="${project.code}"></g:textField></td>
                </tr>
                <tr>
                    <td class="label">Tech lead:</td>
                    <td>
                        <g:select name="techLead.id"
                                  noSelection="${['null':'Select One...']}"
                                  from="${techLeads}"
                                  value="${project?.techLead?.id}"
                                  optionKey="id"
                                  optionValue="fullName"
                                  class="wideSelector"
                        />
                    </td>
                </tr>
                <tr>
                    <td class="label">Project manager:</td>
                    <td>
                        <g:select name="projectManager.id"
                                  noSelection="${['null':'Select One...']}"
                                  from="${managers}"
                                  value="${project?.projectManager?.id}"
                                  optionKey="id"
                                  optionValue="fullName"
                                  class="wideSelector"
                        />
                    </td>
                </tr>
                <tr>
                    <td class="label">Delivery date:</td>
                    <td><g:datePicker name="deliveryDate" precision="day" value="${project.deliveryDate}"></g:datePicker></td>
                </tr>
                <tr>
                    <td class="label">Status:</td>
                    <td>
                        <g:select name="status.id"
                                  from="${statuses}"
                                  value="${project?.status?.id}"
                                  optionKey="id"
                                  optionValue="description"
                                  class="wideSelector"
                        />
                    </td>
                </tr>
                <tr>
                    <td class="label">Priority:</td>
                    <td><g:textField name="priority" value="${project.priority}" class="numericCell"></g:textField></td>
                </tr>
                <tr class="suppressHover">
                    <td></td>
                    <td>
                        <g:actionSubmit value="Back" action="index"></g:actionSubmit>
                        <g:actionSubmit value="Save" action="save"></g:actionSubmit>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>