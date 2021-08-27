<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
  table {
    border: 1px solid #000;
  }

  th, td {
    border: 1px dotted #555;
  }
</style>

<table>
  <caption>Mail box list</caption>
  <thead>
  <tr>
    <th>Id</th>
    <th>Language</th>
    <th>Signature</th>
    <th>EnableSpamFilter</th>
    <th>PageSize</th>
    <th>Action</th>

  </tr>
  </thead>
  <tbody>
  <c:forEach var="email" items="${emailList}">
    <tr>
      <td>
        <c:out value="${email.id}"/>
      </td>

      <td>
        <c:out value="${email.language}"/>
      </td>
      <td>
        <c:out value="${email.signature}"/>
      </td>
      <td>
        <c:out value="${email.enableSpamFilter}"/>
      </td>
      <td>
        <c:out value="${email.pageSize}"/>
      </td>
      <td>
        <a href="/emails/edit/${email.id}">Edit</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>