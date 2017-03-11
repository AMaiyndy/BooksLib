package com.may.bookslib.controller;

import com.may.bookslib.model.Student;
import com.may.bookslib.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }


    @RequestMapping(value = {"/", "/students"}, method = RequestMethod.GET)
    public String getLoginPage() {

        return "students";
    }

//    Create Student
    @RequestMapping(value = "/students/", method = RequestMethod.POST)
    public ResponseEntity<Void> createNewStudent(@RequestBody Student student, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Student " + student.getName());
        this.studentService.addOrEditStudent(student);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/students/{id}").buildAndExpand(student.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

//    Get List of Students
    @RequestMapping(value = "/students/", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> listAllStudents() {
        List<Student> students = this.studentService.getListOfStudents();
        if(students.isEmpty()) {
            return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

//    Get Student by id
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
        System.out.println("Fetching Student with id " + id);
        Student student = this.studentService.getStudentById(id);
        if (student == null) {
            System.out.println("Student with id" + id + " not found");
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

//    Update Student
    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        System.out.println("Updating Student with id " + id);

        Student currentStudent = this.studentService.getStudentById(id);

        if(currentStudent == null) {
            System.out.println("Student with id " + id + " not found");
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }

        currentStudent.setName(student.getName());
        currentStudent.setPassword(student.getPassword());

        this.studentService.addOrEditStudent(currentStudent);
        return new ResponseEntity<Student>(currentStudent, HttpStatus.OK);
    }



//    Delete student
    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") long id) {
        System.out.println("Fetching and Deleting Book with id " + id);

        if(this.studentService.getStudentById(id) == null) {
            System.out.println("Unable to delete. Student with id " + id + " not found");
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }

        this.studentService.removeStudent(id);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public String getStudentsPage(@PathVariable("id") long id) {

        return "student_details";
    }

//    Get Students who took that Book
    @RequestMapping(value = "/stud_book/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudentsWithThatBook(@PathVariable long id) {
        List<Student> studentsWithThatBook = this.studentService.getStudentsWhoTookTheBook(id);

        return new ResponseEntity<List<Student>>(studentsWithThatBook, HttpStatus.OK);
    }
}
