'use strict';

angular.module('bLib').controller('StudentPageController', ['$scope', '$location', 'StudentService', 'BookService',
    function ($scope, $location, StudentService, BookService) {
    var self = this;
    self.sId = $location.absUrl().split("/")[4];
    self.student = getStudentById(self.sId);
    self.books = [];
    self.booksOfStudent= [];
    self.takeBook = takeBook;
    self.returnBook = returnBook;

    fetchAllBooks();
    fetchBooksOfStudent(self.sId);

    function fetchAllBooks() {
        BookService.fetchAllBooks()
            .then(
                function (data) {
                    self.books = data;
                },
                function (errResponse) {
                    console.error('Error while fetching Books');
                }
            );
    }

    function fetchBooksOfStudent(studentId) {
        StudentService.fetchBooksOfStudent(studentId)
            .then(
                function (data) {
                    self.booksOfStudent = data;
                },
                function (errResponse) {
                    console.error('Error while fetching Books of Student');
                }
            );
    }

    function getStudentById(id) {
        StudentService.getStudentById(id)
            .then(
                function (data) {
                    self.student = data;
                },
                function (errResponse) {
                    console.error('Error while getting Student by id');
                }
            );
    }

    function addBookToStudent(bookId, student) {
        StudentService.addBookToStudent(bookId, student)
            .then(
                function() {
                    fetchAllBooks();
                    fetchBooksOfStudent(self.sId);
                },
                function (errResponse) {
                    console.error('Error while taking Book');
                }
            );
    }

    function returnBook(studentId, book) {
        StudentService.deleteBookFromStudentsBookList(studentId, book)
            .then(
                function() {
                    fetchAllBooks();
                    fetchBooksOfStudent(self.student.id);
                },
                function (errResponse) {
                    console.error('Error while deleting Book from Student Book List');
                }
            );
    }

    function takeBook(bookId) {
        addBookToStudent(bookId, self.student);
    }
}]);