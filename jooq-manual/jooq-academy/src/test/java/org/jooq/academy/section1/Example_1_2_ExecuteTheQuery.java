package org.jooq.academy.section1;

import static org.jooq.academy.tools.Tools.connection;
import static org.jooq.example.db.h2.Tables.AUTHOR;

import org.jooq.academy.tools.Tools;
import org.jooq.impl.DSL;

import org.junit.Test;

public class Example_1_2_ExecuteTheQuery {

    @Test
    public void run() {

        // All we need to execute a query is provide it with a connection and then
        // call fetch() on it.
        Tools.title("Selecting FIRST_NAME and LAST_NAME from the AUTHOR table");
        Tools.print(
            DSL.using(connection())
               .select(AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
               .from(AUTHOR)
               .orderBy(AUTHOR.ID)
               .fetch()
        );
    }
}
