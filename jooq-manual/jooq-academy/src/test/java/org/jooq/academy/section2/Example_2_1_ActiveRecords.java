package org.jooq.academy.section2;

import static org.jooq.academy.tools.Tools.connection;
import static org.jooq.example.db.h2.Tables.AUTHOR;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.academy.tools.Tools;
import org.jooq.example.db.h2.tables.records.AuthorRecord;
import org.jooq.impl.DSL;

import org.junit.Test;

public class Example_2_1_ActiveRecords {

    @Test
    public void run() throws SQLException {
        Connection connection = connection();
        DSLContext dsl = DSL.using(connection);

        AuthorRecord author;

        try {
            Tools.title("Loading and changing active records");
            author = dsl.selectFrom(AUTHOR).where(AUTHOR.ID.eq(1)).fetchOne();
            author.setDateOfBirth(Date.valueOf("2000-01-01"));
            author.store();
            Tools.print(author);


            Tools.title("Creating a new active record");
            author = dsl.newRecord(AUTHOR);
            author.setId(3);
            author.setFirstName("Alfred");
            author.setLastName("Hitchcock");
            author.store();
            Tools.print(author);


            Tools.title("Refreshing an active record");
            author = dsl.newRecord(AUTHOR);
            author.setId(3);
            author.refresh();
            Tools.print(author);


            Tools.title("Updating an active record");
            author.setDateOfBirth(Date.valueOf("1899-08-13"));
            author.store();
            Tools.print(author);

            Tools.title("Deleting an active record");
            author.delete();
            Tools.print(dsl.selectFrom(AUTHOR).fetch());
        }
        // Don't store the changes
        finally {
            connection.rollback();
        }
    }
}
