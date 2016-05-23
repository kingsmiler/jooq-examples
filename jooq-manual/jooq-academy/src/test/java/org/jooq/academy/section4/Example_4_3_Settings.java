package org.jooq.academy.section4;

import static java.lang.System.out;
import static org.jooq.SQLDialect.H2;
import static org.jooq.example.db.h2.Tables.AUTHOR;
import static org.jooq.impl.DSL.using;

import org.jooq.Select;
import org.jooq.academy.tools.Tools;
import org.jooq.conf.MappedSchema;
import org.jooq.conf.MappedTable;
import org.jooq.conf.RenderKeywordStyle;
import org.jooq.conf.RenderMapping;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;

import org.junit.Test;

public class Example_4_3_Settings {

    @Test
    public void run() {
        Select<?> select =
        DSL.select()
           .from(AUTHOR)
           .where(AUTHOR.ID.eq(3));

        Tools.title("A couple of settings at work - Formatting");
        out.println(using(H2, new Settings().withRenderFormatted(false)).render(select));
        out.println(using(H2, new Settings().withRenderFormatted(true)).render(select));

        Tools.title("A couple of settings at work - Schema");
        out.println(using(H2, new Settings().withRenderSchema(false)).render(select));
        out.println(using(H2, new Settings().withRenderSchema(true)).render(select));

        Tools.title("A couple of settings at work - Name style");
        out.println(using(H2, new Settings().withRenderNameStyle(RenderNameStyle.AS_IS)).render(select));
        out.println(using(H2, new Settings().withRenderNameStyle(RenderNameStyle.UPPER)).render(select));
        out.println(using(H2, new Settings().withRenderNameStyle(RenderNameStyle.LOWER)).render(select));
        out.println(using(H2, new Settings().withRenderNameStyle(RenderNameStyle.QUOTED)).render(select));

        Tools.title("A couple of settings at work - Keyword style");
        out.println(using(H2, new Settings().withRenderKeywordStyle(RenderKeywordStyle.UPPER)).render(select));
        out.println(using(H2, new Settings().withRenderKeywordStyle(RenderKeywordStyle.LOWER)).render(select));

        Tools.title("A couple of settings at work - Mapping");
        out.println(using(H2, new Settings()
            .withRenderMapping(new RenderMapping()
                .withSchemata(new MappedSchema()
                    .withInput("PUBLIC")
                    .withOutput("test")
                    .withTables(new MappedTable()
                        .withInput("AUTHOR")
                        .withOutput("test-author"))
                )
            )).render(select));

    }
}
