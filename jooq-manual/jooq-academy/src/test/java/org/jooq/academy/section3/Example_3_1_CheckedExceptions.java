package org.jooq.academy.section3;

import static org.jooq.academy.tools.Tools.connection;
import static org.jooq.example.db.h2.Tables.AUTHOR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jooq.academy.tools.Tools;
import org.jooq.impl.DSL;

import org.junit.Test;

public class Example_3_1_CheckedExceptions {

    @Test
    public void run() throws SQLException {
        Connection connection = connection();

        Tools.title("JDBC throws lots of checked exceptions");

        // These two calls can throw a SQLException
        try (PreparedStatement stmt = connection.prepareStatement("SELECT FIRST_NAME FROM AUTHOR");
             ResultSet rs = stmt.executeQuery()) {

            // This can throw a SQLException
            while (rs.next()) {

                // This can throw a SQLException
                System.out.println(rs.getString(1));
            }
        }

        Tools.title("jOOQ doesn't throw any checked exceptions");
        DSL.using(connection)
           .select(AUTHOR.FIRST_NAME)
           .from(AUTHOR)
           .fetch()
           .forEach(record -> System.out.println(record.get(AUTHOR.FIRST_NAME)));
    }
}
