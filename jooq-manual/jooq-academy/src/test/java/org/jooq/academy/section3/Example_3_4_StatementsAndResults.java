package org.jooq.academy.section3;

import static org.jooq.academy.tools.Tools.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jooq.Query;
import org.jooq.Record;
import org.jooq.ResultQuery;
import org.jooq.academy.tools.Tools;
import org.jooq.impl.DSL;

import org.junit.Test;

public class Example_3_4_StatementsAndResults {

    @Test
    public void run() throws SQLException {
        Connection connection = connection();

        Tools.title("If you don't know whether a result set is produced with JDBC");
        try (PreparedStatement stmt = connection.prepareStatement("SELECT FIRST_NAME FROM AUTHOR")) {
            boolean moreResults = stmt.execute();

            do {
                if (moreResults) {
                    try (ResultSet rs = stmt.getResultSet()) {
                        while (rs.next()) {
                            System.out.println(rs.getString(1));
                        }
                    }
                }
                else {
                    System.out.println(stmt.getUpdateCount());
                }
            } while ((moreResults = stmt.getMoreResults()) || stmt.getUpdateCount() != -1);
        }

        Tools.title("You always know whether a result set is produced with jOOQ, because of the type");
        Query q1 = DSL.using(connection).query("UPDATE AUTHOR SET LAST_NAME = LAST_NAME");
        System.out.println(
            q1.execute()
        );

        ResultQuery<Record> q2 = DSL.using(connection).resultQuery("SELECT * FROM AUTHOR");
        System.out.println(
            q2.fetch()
        );
    }
}
