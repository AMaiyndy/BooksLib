<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html ng-app="bLib">
<head>
    <title>Books</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"></link>
    <link rel="stylesheet" href="<c:url value="/resources/css/app.css"/>"></link>
    <script src="<c:url value="/resources/js/angularjs.min.js"/>"></script>
    <script src="<c:url value="/resources/js/app.js"/>"></script>
    <script src="<c:url value="/resources/js/service/book_service.js"/>"></script>
    <script src="<c:url value="/resources/js/controller/book_cntrl.js"/>"></script>
</head>
<body ng-controller="BookController as ctrl">
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Add/Edit book form</span></div>
        <div class="formcontainer">
            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                <input type="hidden" ng-model="ctrl.book.id"/>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="btitle" class="col-md-2 control-label">Title</label>
                        <div class="col-md-7">
                            <input type="text" class="form-control input-sm" ng-model="ctrl.book.title" id="btitle" placeholder="Enter the title"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="bauthor" class="col-md-2 control-label">Author</label>
                        <div class="col-md-7">
                            <input type="text" class="form-control input-sm" ng-model="ctrl.book.author" id="bauthor" placeholder="Enter the author"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="bquantity" class="col-md-2 control-label">Quantity</label>
                        <div class="col-md-7">
                            <input type="text" class="form-control input-sm" ng-model="ctrl.book.quantity" id="bquantity" placeholder="Enter the quantity"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div align="center">
                        <input type="submit"  value="{{!ctrl.book.id ? 'Add' : 'Edit'}}" class="btn">
                        <button type="button" ng-click="ctrl.reset()" class="btn">Reset Form</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <br/><br/>
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">List of Books </span></div>
        <table class="table">
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
                    <button type="button" ng-click="ctrl.edit(book.id)" class="btn">Edit</button>
                    <button type="button" ng-click="ctrl.remove(book.id)" class="btn">Delete</button>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
