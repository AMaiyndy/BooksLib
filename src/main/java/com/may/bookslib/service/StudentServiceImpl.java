package com.may.bookslib.service;

import com.may.bookslib.dao.BookDao;
import com.may.bookslib.dao.StudentDao;
import com.may.bookslib.model.Book;
import com.may.bookslib.model.Student;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;
    private BookDao bookDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void addOrEditStudent(Student student) {
        if(student.getId() > 0) {
            this.studentDao.updateStudent(student);
        } else {
            this.studentDao.addStudent(student);
        }
    }

    @Override
    public void removeStudent(long id) {
        this.studentDao.removeStudent(id);
    }


    @Override
    public Student getStudentById(long id) {
        return this.studentDao.getStudentById(id);
    }

    @Override
    public Student getStudentByName(String name) {
        return this.studentDao.getStudentByName(name);
    }

    @Override
    public List<Student> getListOfStudents() {
        return this.studentDao.getListOfStudents();
    }

    @Override
    public List<Student> getStudentsWhoTookTheBook(long id) {
        return this.studentDao.getStudentsWhoTookTheBook(id);
    }
}
