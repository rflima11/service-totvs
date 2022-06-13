package br.com.businesstec.servicetotvs.config;

import com.sun.xml.bind.marshaller.CharacterEscapeHandler;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class XmlCharacterHandler implements CharacterEscapeHandler {

    public void escape(char[] buf, int start, int len, boolean isAttValue,
                       Writer out) throws IOException {
        StringWriter buffer = new StringWriter();

        for (int i = start; i < start + len; i++) {
            buffer.write(buf[i]);
        }

        String st = buffer.toString();

        if (!st.contains("CDATA")) {
            st = buffer.toString().replace("&", "&amp;").replace("<", "&lt;")
                    .replace(">", "&gt;").replace("'", "&apos;")
                    .replace("\"", "&quot;");

        }
        out.write(st);
        System.out.println(st);
        System.out.println("CHAAAAAAAAAAAAMBRA FIO");

    }

}
