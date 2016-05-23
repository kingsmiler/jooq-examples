package org.jooq.academy.section4;

import java.util.Arrays;

import org.jooq.SQLDialect;
import org.jooq.academy.tools.Tools;
import org.jooq.impl.DSL;

import org.junit.Test;

public class Example_4_2_SQLDialect {

    @Test
    public void run() {
        Tools.title("Generate SELECT 1 FROM DUAL for all SQL dialect families");
        Arrays.stream(SQLDialect.families())
              .map(dialect -> String.format("%15s : ", dialect) + DSL.using(dialect).render(DSL.selectOne()))
              .forEach(System.out::println);
    }
}
