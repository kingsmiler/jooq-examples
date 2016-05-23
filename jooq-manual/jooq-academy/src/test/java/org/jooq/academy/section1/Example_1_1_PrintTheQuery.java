package org.jooq.academy.section1;

import static org.jooq.example.db.h2.Tables.AUTHOR;
import static org.jooq.impl.DSL.select;

import org.jooq.academy.tools.Tools;

import org.junit.Test;

public class Example_1_1_PrintTheQuery {

    @Test
    public void run() {

        // This creates a simple query without executing it
        // By default, a Query's toString() method will print the SQL string to the console
        Tools.title("Create a simple query without executing it");
        Tools.print(
             select(AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
            .from(AUTHOR)
            .orderBy(AUTHOR.ID)
        );
    }
}
