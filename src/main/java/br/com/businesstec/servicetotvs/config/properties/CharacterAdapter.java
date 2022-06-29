package br.com.businesstec.servicetotvs.config.properties;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CharacterAdapter extends XmlAdapter<String, Character> {

    @Override
    public Character unmarshal(String s) throws Exception {
        return s.charAt(0);
    }

    @Override
    public String marshal(Character character) throws Exception {
        return new String(new char[] {character});
    }
}
