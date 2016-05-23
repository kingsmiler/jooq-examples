package org.jooq.academy.section3;

import static org.jooq.academy.tools.Tools.connection;
import static org.jooq.example.db.h2.Tables.AUTHOR;

import java.sql.Connection;
import java.util.Arrays;

import org.jooq.Record;
import org.jooq.academy.tools.Tools;
import org.jooq.impl.DSL;

import org.junit.Test;

public class Example_3_2_ResultSets {

    @Test
    public void run() {
        Connection connection = connection();

        Tools.title("Using jOOQ Results in foreach loops");
        for (Record record : DSL.using(connection)
                                .select()
                                .from(AUTHOR)
                                .fetch()) {
            System.out.println(record);
        }

        Tools.title("Using jOOQ Results with Java 8 streams");
        DSL.using(connection)
           .select()
           .from(AUTHOR)
           .fetch()
           .stream()
           .flatMap(record -> Arrays.stream(record.intoArray()))
           .forEach(System.out::println);
    }
}
