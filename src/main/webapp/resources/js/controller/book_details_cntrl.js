'use strict';

angular.module('bLib').controller('BooksPageController', ['$scope', '$location', 'StudentService', 'BookService',
    function ($scope, $location, StudentService, BookService) {
        var self = this;
        self.sId = $location.absUrl().split("/")[4];
        self.book = getBookById(self.sId);
        self.students = [];

        fetchStudentsWhoTookTheBook(self.sId);

        function fetchStudentsWhoTookTheBook(id) {
            BookService.fetchStudentsWhoTookTheBook(id)
                .then(
                    function (data) {
                        self.students = data;
                    },
                    function (errResponse) {
                        console.error('Error while fetching Students');
                    }
                );
        }

        function getBookById(id) {
            BookService.getBookById(id)
                .then(
                    function (data) {
                        self.book = data;
                    },
                    function (errResponse) {
                        console.error('Error while getting Book by id');
                    }
                );
        }

    }]);