CREATE DATABASE books_lib;

# create books
CREATE TABLE `books` (
  `ID`            BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `BOOK_TITLE`    VARCHAR(55) NOT NULL,
  `BOOK_AUTHOR`   VARCHAR(55) NOT NULL,
  `BOOK_QUANTITY` BIGINT(20)  NOT NULL,
  PRIMARY KEY (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# create students
CREATE TABLE `students` (
  `id`       BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `name`     VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


# create students_books
CREATE TABLE `students_books` (
  `student_id` BIGINT(20) NOT NULL,
  `book_id`    BIGINT(20) NOT NULL,
  UNIQUE KEY `student_id` (`student_id`, `book_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `students_books_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `students_books_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`ID`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

#inserts
INSERT INTO books VALUES (1, "Thinking in Java", "Eckel", 5);
INSERT INTO students VALUES (1, Anton, Anton1234);
INSERT INTO students_books VALUES (1, 1);


