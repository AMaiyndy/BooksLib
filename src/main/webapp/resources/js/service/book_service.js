'use strict';

angular.module('bLib').factory('BookService', ['$http', '$q', function ($http, $q) {
    var SERVICE_URI = 'http://localhost:8080/books/';

    var factory = {
        fetchAllBooks: fetchAllBooks,
        fetchStudentsWhoTookTheBook: fetchStudentsWhoTookTheBook,
        getBookById: getBookById,
        createBook: createBook,
        updateBook: updateBook,
        deleteBook: deleteBook
    };

    return factory;

    function fetchAllBooks() {
        var deffered = $q.defer();
        $http.get(SERVICE_URI)
            .then(
                function (response) {
                    deffered.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching Books');
                    deffered.reject(errResponse);
                }
            );
        return deffered.promise;
    }

    function fetchStudentsWhoTookTheBook(bookId) {
        var deffered = $q.defer();
        $http.get('http://localhost:8080/stud_book/' + bookId)
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

    function getBookById(id) {
        var deffered = $q.defer();
        $http.get(SERVICE_URI+id)
            .then(
                function (response) {
                    deffered.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while getting Book by id');
                    deffered.reject(errResponse);
                }
            );
        return deffered.promise;
    }



    function createBook(book) {
        var deffered = $q.defer();
        $http.post(SERVICE_URI, book)
            .then(
                function (response) {
                    deffered.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while creating Book');
                    deffered.reject(errResponse);
                }
            );
        return deffered.promise;
    }

    function updateBook(book, id) {
        var deffered = $q.defer();
        $http.put(SERVICE_URI+id, book)
            .then(
                function (response) {
                    deffered.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while updating Book');
                    deffered.reject(errResponse);
                }
            );
        return deffered.promise;
    }

    function deleteBook(id) {
        var deffered = $q.defer();
        $http.delete(SERVICE_URI+id)
            .then(
                function (response) {
                    deffered.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while deleting Book');
                    deffered.reject(errResponse);
                }
            );
        return deffered.promise;
    }
}]);