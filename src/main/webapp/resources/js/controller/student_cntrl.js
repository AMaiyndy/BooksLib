'use strict';

angular.module('bLib').controller('StudentController', ['$scope', 'StudentService', function ($scope, StudentService) {
    var self = this;
    self.student = {id:null, name:'', password:'', books:[]};
    self.students = [];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

    fetchAllStudents();

    function fetchAllStudents() {
        StudentService.fetchAllStudents()
            .then(
                function (data) {
                    self.students = data;
                },
                function (errResponse) {
                    console.error('Error while fetching Students');
                }
            );
    }

    function createStudent(student) {
        StudentService.createStudent(student)
            .then(
                fetchAllStudents,
                function (errResponse) {
                    console.error('Error while creating Student')
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

    function getStudentByName(name) {
        StudentService.getStudentByName(name)
            .then(
                function (data) {
                    self.student = data;
                },
                function (errResponse) {
                    console.error('Error while getting Student by name');
                }
            );
    }

    function updateStudent(student, id) {
        StudentService.updateStudent(student, id)
            .then(
                fetchAllStudents,
                function (errResponse) {
                    console.error('Error while updating Student')
                }
            );

    }

    function deleteStudent(id){
        StudentService.deleteStudent(id)
            .then(
                fetchAllStudents,
                function (errResponse) {
                    console.error('Error while deleting Student')
                }
            );
    }

    function submit() {
        if (self.student.id === null){
            console.log('Saving New Student', self.student);
            createStudent(self.student);
        } else {
            updateStudent(self.student, self.student.id);
            console.log('Student updated with id', self.student.id);
        }
        reset();
    }

    function edit(id) {
        console.log('id (Student) to be edited', id);
        for (var i = 0; i < self.students.length; i++) {
            if(self.students[i].id === id) {
                self.student = angular.copy(self.students[i]);
                break;
            }
        }
    }

    function remove(id) {
        console.log('id (Student) to be deleted', id);
        if (self.student.id === id) {
            reset();
        }
        deleteStudent(id);
    }


    function reset() {
        self.student={id:null, name:'', password:'', books:[]};
        $scope.studentForm.$setPristine();
    }
}]);