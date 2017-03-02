<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html ng-app="bLib">
<head>
    <title>Books</title>
    <script src="<c:url value="/resources/js/angularjs.min.js"/>"></script>
    <script src="<c:url value="/resources/js/app.js"/>"></script>
    <script src="<c:url value="/resources/js/service/book_service.js"/>"></script>
    <script src="<c:url value="/resources/js/controller/book_cntrl.js"/>"></script>
</head>
<body ng-controller="BookController as ctrl">
    <div>Add/Edit book form</div>
    <form ng-submit="ctrl.submit()" name="myForm">
        <input type="hidden" ng-model="ctrl.book.id"/> <br/>
        <label for="btitle">Title</label> <br/>
        <input type="text" ng-model="ctrl.book.title" id="btitle" placeholder="Enter the title"/> <br/>
        <label for="bauthor">Author</label> <br/>
        <input type="text" ng-model="ctrl.book.author" id="bauthor" placeholder="Enter the author"/> <br/>
        <label for="bquantity">Quantity</label> <br/>
        <input type="text" ng-model="ctrl.book.quantity" id="bquantity" placeholder="Enter the quantity"/> <br/>
        <input type="submit" value="{{!ctrl.book.id ? 'Add' : 'Edit'}}">
        <button type="button" ng-click="ctrl.reset()">Reset form</button>
    </form>
    <br/><br/>
    <table>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Author</th>
            <th>Quantity</th>
            <th>Action</th>
        </tr>
        <tr ng-repeat="book in ctrl.books">
            <td>{{book.id}}</td>
            <td>{{book.title}}</td>
            <td>{{book.author}}</td>
            <td>{{book.quantity}}</td>
            <td>
                <button type="button" ng-click="ctrl.edit(book.id)">Edit</button>
                <button type="button" ng-click="ctrl.remove(book.id)">Delete</button>
            </td>
        </tr>
    </table>
</body>
</html>
