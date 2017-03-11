package com.may.bookslib.dao;

import com.may.bookslib.model.Book;
import com.may.bookslib.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_INSERT = "INSERT INTO students (name, password) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE students SET name=?, password=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM students WHERE id=?";
    private static final String SQL_SELECT = "SELECT * FROM students";
    private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id=?";
    private static final String SQL_SELECT_BY_NAME = SQL_SELECT + " WHERE name=?";
    private static final String SQL_GET_STUDENTS_WHO_TOOK_THE_BOOK="SELECT s.id, s.name, s_b.book_id FROM " +
            "students_books s_b INNER JOIN students s ON s_b.student_id = s.id WHERE s_b.book_id = ?";

    @Autowired
    public void setJdbcTemplate(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addStudent(Student student) {
        String sql = SQL_INSERT;
        jdbcTemplate.update(sql, student.getName(), student.getPassword());
    }

    @Override
    public void updateStudent(Student student) {
        String sql = SQL_UPDATE;
        jdbcTemplate.update(sql, student.getName(), student.getPassword(), student.getId());
    }

    @Override
    public void removeStudent(long id) {
        String sql = SQL_DELETE;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Student getStudentById(long id) {
        String sql = SQL_SELECT_BY_ID;

        return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
    }

    @Override
    public Student getStudentByName(String name) {
        String sql = SQL_SELECT_BY_NAME;
        return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), name);
    }

    @Override
    public List<Student> getListOfStudents() {
        String sql = SQL_SELECT;

        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    @Override
    public List<Student> getStudentsWhoTookTheBook(long id) {
        String sql = SQL_GET_STUDENTS_WHO_TOOK_THE_BOOK;
        return jdbcTemplate.query(sql, new StudentBookRowMapper(), id);
    }

    private static final class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet rs, int i) throws SQLException {
            return new Student(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("password"));
        }
    }

    private static final class StudentBookRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet rs, int i) throws SQLException {
            return new Student(
                    rs.getLong("id"),
                    rs.getString("name"));
        }
    }
}
