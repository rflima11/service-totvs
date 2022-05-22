package br.com.businesstec.servicetotvs.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CDATAAdapter extends XmlAdapter<String, String> {

    @Override
    public String marshal(String inStr) throws Exception {
        return "<![CDATA[" + inStr + "]]>";
    }

    @Override
    public String unmarshal(String v) throws Exception {
        return v;
    }
}
