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
public class BookDaoImpl implements BookDao {
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_INSERT = "INSERT INTO books (BOOK_TITLE, BOOK_AUTHOR, BOOK_QUANTITY) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE books SET BOOK_TITLE=?, BOOK_AUTHOR=?, BOOK_QUANTITY=? WHERE ID=?";
    private static final String SQL_DELETE = "DELETE FROM books WHERE ID=?";
    private static final String SQL_SELECT = "SELECT * FROM books";
    private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE ID=?";
    private static final String SQL_GET_BOOKS_OF_STUDENT ="SELECT b.ID, b.BOOK_TITLE, b.BOOK_AUTHOR, s_b.student_id FROM " +
            "students_books s_b INNER JOIN books b ON s_b.book_id = b.ID WHERE s_b.student_id = ?";
    private static final String SQL_CHANGE_BOOK_QUANTITY="UPDATE books SET BOOK_QUANTITY=? WHERE ID=?";
    private static final String SQL_ADD_BOOK_TO_STUDENT="INSERT INTO students_books (student_id, book_id) VALUES (?, ?)";
    private static final String SQL_RETURN_BOOK="DELETE FROM students_books WHERE (student_id=?) AND (book_id=?)";


    @Autowired
    public void setJdbcTemplate(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addBook(Book book) {
        String sql = SQL_INSERT;
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getQuantity());
    }

    @Override
    public void updateBook(Book book) {
        String sql = SQL_UPDATE;
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getQuantity(), book.getId());
    }

    @Override
    public void removeBook(long id) {
        String sql = SQL_DELETE;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void addBookToStudent(long studentId, long bookId) {
        jdbcTemplate.update(SQL_ADD_BOOK_TO_STUDENT, studentId, bookId);
    }

    @Override
    public void returnBook(long studentId, long bookId) {
        jdbcTemplate.update(SQL_RETURN_BOOK, studentId, bookId);
    }

    @Override
    public void changeBookQuantity(long quantity, long id) {
        jdbcTemplate.update(SQL_CHANGE_BOOK_QUANTITY, quantity, id);
    }

    @Override
    public Book getBookById(long id) {
        String sql = SQL_SELECT_BY_ID;

        return jdbcTemplate.queryForObject(sql, new BookRowMapper(), id);
    }

    @Override
    public List<Book> getListOfBooks() {
        String sql = SQL_SELECT;

        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    @Override
    public List<Book> getBooksOfStudent(long id) {
        String sql = SQL_GET_BOOKS_OF_STUDENT;
        return jdbcTemplate.query(sql, new BookStudentRowMapper(), id);
    }


    private static final class BookRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {
            return new Book(
                    rs.getLong("ID"),
                    rs.getString("BOOK_TITLE"),
                    rs.getString("BOOK_AUTHOR"),
                    rs.getLong("BOOK_QUANTITY"));
        }
    }

    private static final class BookStudentRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {
            return new Book(
                    rs.getLong("ID"),
                    rs.getString("BOOK_TITLE"),
                    rs.getString("BOOK_AUTHOR"));
        }
    }
}
