package com.may.bookslib.dao;

import com.may.bookslib.model.Student;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);

    void updateStudent(Student student);

    void removeStudent(long id);

    Student getStudentById(long id);

    Student getStudentByName(String name);

    List<Student> getListOfStudents();

    List<Student> getStudentsWhoTookTheBook(long id);
}
