# jOOQ Maven Tutorial

A short example how to combine the Maven jOOQ Plugin, the Maven Build Helper Plugin and Maven Profiles to create your database metamodel in no time.

For more detailed information, please feel free to have a look at [my blog].

## Database Schema

This is the structure of the test database (mysql):

    CREATE TABLE book (
      id BIGINT PRIMARY KEY, 
      title VARCHAR(255)
    );

    CREATE TABLE author(
      id BIGINT PRIMARY KEY, 
      name VARCHAR(255)
    );

    CREATE TABLE book_author_rel (
      bookid BIGINT NOT NULL, 
      authorid BIGINT NOT NULL,
      FOREIGN KEY fk_book(bookid)
      REFERENCES book(id),
      FOREIGN KEY fk_author(authorid)
      REFERENCES author(id)
    );


And some content ..

    INSERT INTO book VALUES
      (1, 'Some book'),
      (2, 'Another Book'),
      (3, 'Some completely other book')
    ;

    INSERT into author VALUES
      (1, 'tim'), 
      (2, 'selena'), 
      (3, 'thelma')
    ;

    INSERT INTO book_author_rel VALUES
      (1,1),
      (2,2),
      (3,2)
    ;

## Generating the Metamodel

Simply run the following command:

    mvn compile exec:java -Dexec.mainClass=com.hascode.tutorial.BookStore

You should see some output from the jOOQ model generator and finally the following output from the query:

    Another Book (id: 2)
    Some completely other book (id: 3)


----

**2014 Micha Kops / hasCode.com**

   [my blog]:http://www.hascode.com/
