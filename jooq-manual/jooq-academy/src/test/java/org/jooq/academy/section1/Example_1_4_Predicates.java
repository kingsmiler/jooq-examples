package org.jooq.academy.section1;

import static org.jooq.academy.tools.Tools.connection;
import static org.jooq.example.db.h2.Tables.AUTHOR;
import static org.jooq.example.db.h2.Tables.BOOK;
import static org.jooq.impl.DSL.select;

import org.jooq.DSLContext;
import org.jooq.academy.tools.Tools;
import org.jooq.impl.DSL;

import org.junit.Test;

public class Example_1_4_Predicates {

    @Test
    public void run() {
        DSLContext dsl = DSL.using(connection());

        Tools.title("Combine predicates using AND");
        Tools.print(
            dsl.select()
               .from(BOOK)
               .where(BOOK.TITLE.like("%a%").and(BOOK.AUTHOR_ID.eq(1)))
               .fetch()
        );

        Tools.title("Use an IN-predicate");
        Tools.print(
            dsl.select()
               .from(AUTHOR)
               .where(AUTHOR.ID.in(select(BOOK.AUTHOR_ID).from(BOOK)))
               .fetch()
        );

        /*
        Tools.title("Wrong type of columns in subquery");
        Tools.print(
            dsl.select()
               .from(AUTHOR)
               .where(AUTHOR.ID.in(select(BOOK.TITLE).from(BOOK)))
               .fetch()
        );
        */

        /*
        Tools.title("Wrong number of columns in subquery");
        Tools.print(
            dsl.select()
               .from(AUTHOR)
               .where(AUTHOR.ID.in(select(BOOK.AUTHOR_ID, BOOK.TITLE).from(BOOK)))
               .fetch()
        );
        */
    }
}
