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
    <caption>People List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Triệu chứng</th>
        <th>Đi lại</th>
        <th>Tiếp xúc</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="people" items="${peoples}">
        <tr>
            <td>
                <c:out value="${people.id}"/>
            </td>
            <td>
                <a href="/peoples/edit/${people.id}">${people.name}</a>
            </td>
            <td>
                <c:out value="${people.email}"/>
            </td>
            <td>
                <c:out value="${people.address}"/>
            </td>
            <td>
                <c:out value="${people.symptom}"/>
            </td>
            <td>
                <c:out value="${people.information}"/>
            </td>
            <td>
                <c:out value="${people.exposureHistory}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>