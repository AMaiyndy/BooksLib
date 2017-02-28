create database books_lib;
use books_lib;

create table books(
  ID bigint not null auto_increment,
  BOOK_TITLE varchar(55) not null,
  BOOK_AUTHOR varchar(55) not null,
  BOOK_QUANTITY bigint not null,
  primary key(ID));

insert into books values(1, "Thinking in Java", "Eckel", 5);