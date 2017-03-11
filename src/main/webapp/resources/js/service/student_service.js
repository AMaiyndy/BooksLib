'use strict';

angular.module('bLib').factory('StudentService', ['$http', '$q', function ($http, $q) {
    var SERVICE_URI = 'http://localhost:8080/students/';

    var factory = {
        fetchAllStudents: fetchAllStudents,
        fetchBooksOfStudent: fetchBooksOfStudent,
        getStudentById: getStudentById,
        getStudentByName: getStudentByName,
        deleteBookFromStudentsBookList: deleteBookFromStudentsBookList,
        createStudent: createStudent,
        updateStudent: updateStudent,
        deleteStudent: deleteStudent,
        addBookToStudent: addBookToStudent
    };

    return factory;

    function fetchAllStudents() {
        var deffered = $q.defer();
        $http.get(SERVICE_URI)
            .then(
                function (response) {
                    deffered.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching Students');
                    deffered.reject(errResponse);
                }
            );
        return deffered.promise;
    }

    function fetchBooksOfStudent(studentId) {
        var deffered = $q.defer();
        $http.get('http://localhost:8080/book_stud/' + studentId)
            .then(
                function (response) {
                    deffered.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching Book details');
                    deffered.reject(errResponse);
                }
            );
        return deffered.promise;
    }

    function getStudentById(id) {
        var deffered = $q.defer();
        $http.get(SERVICE_URI+id)
            .then(
                function (response) {
                    deffered.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while getting Student by id');
                    deffered.reject(errResponse);
                }
            );
        return deffered.promise;
    }

    function deleteBookFromStudentsBookList(bookId, student) {
        var deffered = $q.defer();
        $http.delete('http://localhost:8080/stud_book/'+bookId, student)
            .then(
                function (response) {
                    deffered.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while deleting Book from student Book List');
                    deffered.reject(errResponse);
                }
            );
        return deffered.promise;
    }

    function getStudentByName(name) {
        var deffered = $q.defer();
        $http.get(SERVICE_URI+name)
            .then(
                function (response) {
                    deffered.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while getting Student by name');
                    deffered.reject(errResponse);
                }
            );
        return deffered.promise;
    }

    function addBookToStudent(bookId, student) {
        var deffered = $q.defer();
        $http.post('http://localhost:8080/stud_book/' + bookId, student)
            .then(
                function (response) {
                    deffered.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while adding book to student');
                    deffered.reject(errResponse);
                }
            );
        return deffered.promise;
    }

    function createStudent(student) {
        var deffered = $q.defer();
        $http.post(SERVICE_URI, student)
            .then(
                function (response) {
                    deffered.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while registering Student');
                    deffered.reject(errResponse);
                }
            );
        return deffered.promise;
    }

    function updateStudent(student, id) {
        var deffered = $q.defer();
        $http.put(SERVICE_URI+id, student)
            .then(
                function (response) {
                    deffered.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while updating Student');
                    deffered.reject(errResponse);
                }
            );
        return deffered.promise;
    }

    function deleteStudent(id){
        var deffered = $q.defer();
        $http.delete(SERVICE_URI+id)
            .then(
                function (response) {
                    deffered.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while deleting Student');
                    deffered.reject(errResponse);
                }
            );
        return deffered.promise;
    }

}]);