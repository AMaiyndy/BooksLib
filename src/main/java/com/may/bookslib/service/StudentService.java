package com.may.bookslib.service;

import com.may.bookslib.model.Book;
import com.may.bookslib.model.Student;

import java.util.List;

public interface StudentService {
    void addOrEditStudent(Student student);

    void removeStudent(long id);



    Student getStudentById(long id);

    Student getStudentByName(String name);

    List<Student> getListOfStudents();

    List<Student> getStudentsWhoTookTheBook(long id);
}
