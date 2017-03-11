<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html ng-app="bLib">
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"></link>
    <link rel="stylesheet" href="<c:url value="/resources/css/app.css"/>"></link>
    <script src="<c:url value="/resources/js/angular.min.js"/>"></script>
    <script src="<c:url value="/resources/js/app.js"/>"></script>
    <script src="<c:url value="/resources/js/service/student_service.js"/>"></script>
    <script src="<c:url value="/resources/js/controller/student_cntrl.js"/>"></script>
</head>
<body ng-controller="StudentController as sCtrl">
<%--<div class="navbar-fixed-top">--%>
    <%--<span><a href="<c:url value='/books'/>">Books</a></span>--%>
    <%--<span><a href="<c:url value='/students'/>">Students</a></span>--%>
<%--</div>--%>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Register/Edit Student form</span></div>
        <div class="formcontainer">
            <form ng-submit="sCtrl.submit()" name="studentForm" class="form-horizontal">
                <input type="hidden" ng-model="sCtrl.student.id"/>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="sName" class="col-md-2 control-label">Name</label>
                        <div class="col-md-7">
                            <input type="text" class="form-control input-sm" ng-model="sCtrl.student.name" id="sName" placeholder="Enter the name"/>
                        </div>
                    </div>
                </div>
                <%--<div class="row">--%>
                    <%--<div class="form-group col-md-12">--%>
                        <%--<label for="sPassword" class="col-md-2 control-label">Password</label>--%>
                        <%--<div class="col-md-7">--%>
                            <%--<input type="password" class="form-control input-sm" ng-model="sCtrl.student.password" id="sPassword" placeholder="Enter the password"/>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <div class="row">
                    <div align="center">
                        <input type="submit"  value="{{!sCtrl.student.id ? 'Add' : 'Edit'}}" class="btn">
                        <button type="button" ng-click="sCtrl.reset()" class="btn">Reset Form</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <br/><br/>
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">List of Students</span></div>
        <table class="table table-hover">
            <tr>
                <th>Id</th>
                <th>Name</th>
            </tr>
            <tr ng-repeat="student in sCtrl.students">
                <td>{{student.id}}</td>
                <td><a href="<c:url value='/student/{{student.id}}'/>">{{student.name}}</a></td>
                <td>
                    <button type="button" ng-click="sCtrl.edit(student.id)" class="btn">Edit</button>
                    <button type="button" ng-click="sCtrl.remove(student.id)" class="btn">Delete</button>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
