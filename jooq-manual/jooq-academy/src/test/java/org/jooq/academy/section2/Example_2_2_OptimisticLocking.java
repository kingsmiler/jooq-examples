package org.jooq.academy.section2;

import static org.jooq.academy.tools.Tools.connection;
import static org.jooq.example.db.h2.Tables.BOOK;

import java.sql.Connection;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.academy.tools.Tools;
import org.jooq.conf.Settings;
import org.jooq.example.db.h2.tables.records.BookRecord;
import org.jooq.exception.DataChangedException;
import org.jooq.impl.DSL;

import org.junit.Test;

public class Example_2_2_OptimisticLocking {

    @Test
    public void run() throws SQLException {
        Connection connection = connection();
        DSLContext dsl = DSL.using(connection, new Settings().withExecuteWithOptimisticLocking(true));

        try {
            Tools.title("Applying optimistic locking");

            BookRecord book1 = dsl.selectFrom(BOOK).where(BOOK.ID.eq(1)).fetchOne();
            BookRecord book2 = dsl.selectFrom(BOOK).where(BOOK.ID.eq(1)).fetchOne();

            book1.setTitle("New Title");
            book1.store();

            book2.setTitle("Another Title");
            book2.store();
        }
        catch (DataChangedException expected) {
            expected.printStackTrace();
        }
        // Don't store the changes
        finally {
            connection.rollback();
        }
    }
}
