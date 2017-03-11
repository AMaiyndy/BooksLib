<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="bLib">
<head>
    <title>Student's Page</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"></link>
    <link rel="stylesheet" href="<c:url value="/resources/css/app.css"/>"></link>
    <script src="<c:url value="/resources/js/angular.min.js"/>"></script>
    <script src="<c:url value="/resources/js/app.js"/>"></script>
    <script src="<c:url value="/resources/js/service/student_service.js"/>"></script>
    <script src="<c:url value="/resources/js/service/book_service.js"/>"></script>
    <script src="<c:url value="/resources/js/controller/student_details_cntrl.js"/>"></script>
</head>
<body ng-controller="StudentPageController as spCtrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Student's Info</span></div>
        <table class="table table-hover">
            <tr>
                <th>Id</th>
                <th>Name</th>
            </tr>
            <tr>
                <td>{{spCtrl.student.id}}</td>
                <td>{{spCtrl.student.name}}</td>
            </tr>
        </table>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">List of Books </span></div>
        <table class="table table-hover">
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Author</th>
                <th>Quantity</th>
                <th>Action</th>
            </tr>
            <tr ng-repeat="book in spCtrl.books">
                <td>{{book.id}}</td>
                <td><a href="/book/{{book.id}}" target="_blank">{{book.title}}</a></td>
                <td>{{book.author}}</td>
                <td>{{book.quantity}}</td>
                <td>
                    <button type="button" ng-click="spCtrl.takeBook(book.id)" class="btn">Take</button>
                </td>
            </tr>
        </table>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">List of Student's Books </span></div>
        <table class="table table-hover">
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Author</th>
            </tr>
            <tr ng-repeat="bookOfStudent in spCtrl.booksOfStudent">
                <td>{{bookOfStudent.id}}</td>
                <td>{{bookOfStudent.title}}</td>
                <td>{{bookOfStudent.author}}</td>
                <td>
                    <button type="button" ng-click="spCtrl.returnBook(bookOfStudent)" class="btn">Return</button>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
