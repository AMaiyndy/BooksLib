<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="bLib">
<head>
    <title>Book Details</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"></link>
    <link rel="stylesheet" href="<c:url value="/resources/css/app.css"/>"></link>
    <script src="<c:url value="/resources/js/angular.min.js"/>"></script>
    <script src="<c:url value="/resources/js/app.js"/>"></script>
    <script src="<c:url value="/resources/js/service/student_service.js"/>"></script>
    <script src="<c:url value="/resources/js/service/book_service.js"/>"></script>
    <script src="<c:url value="/resources/js/controller/book_details_cntrl.js"/>"></script>
</head>
<body ng-controller="BooksPageController as bpCtrl">
<div class="panel panel-default">
    <div class="panel-heading"><span class="lead">Book's Info</span></div>
    <table class="table table-hover">
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Author</th>
        </tr>
        <tr>
            <td>{{bpCtrl.book.id}}</td>
            <td>{{bpCtrl.book.title}}</td>
            <td>{{bpCtrl.book.author}}</td>
        </tr>
    </table>
</div>
<div class="panel panel-default">
    <div class="panel-heading"><span class="lead">List of Students Have Got That Book </span></div>
    <table class="table table-hover">
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <tr ng-repeat="student in bpCtrl.students">
            <td>{{student.id}}</td>
            <td>{{student.name}}</td>
        </tr>
    </table>
</div>
</body>
</html>
