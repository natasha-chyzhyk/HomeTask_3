package com.natasha.sourceit.task18;

import javafx.beans.binding.IntegerBinding;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.print.attribute.IntegerSyntax;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

public class Main {

    public static void main(String[] args)
            throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory =
                SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        String path = "src\\com\\natasha\\sourceit\\task18\\staff.xml";
        DefaultHandler handler = new MyHandler();
        saxParser.parse(path, handler);

        System.out.println();
    }

    public static class MyHandler extends DefaultHandler {

        Staff buff = null;
        List<Staff> staffs = new ArrayList();
        StringBuilder sb = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            String out = "START " + qName + " " + attributes.getLength();
            System.out.println(out);
            if(qName.equals("staff")) {
                buff = new Staff();
            }
            sb = new StringBuilder();
            if(qName.equalsIgnoreCase("staff") && attributes.getLength() > 0) {
                buff.setId(attributes.getValue("id"));
                System.out.println("Id is " + attributes.getValue("id"));
            }
            if(qName.equalsIgnoreCase("sallary") && attributes.getLength() > 0) {
                buff.setIsRegular(Boolean.parseBoolean(attributes.getValue("isRegular")));
                System.out.println("isRegular salary " + attributes.getValue("isRegular"));
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            char[] result = new char[length];
            for(int i = 0; i < length; i++) {
                result[i] = ch[start + i];
            }
            String str = new String(result);
            sb.append(str);
        }

        @Override
        public void endElement(String uri, String localName,
                               String qName) throws SAXException {
            if(qName.equalsIgnoreCase("firstname")) {
                buff.setFirsstName(sb.toString());
            }
            if(qName.equalsIgnoreCase("lastname")) {
                buff.setLastName(sb.toString());
            }
            if(qName.equalsIgnoreCase("sallary")){
                buff.setSallaryValue(Double.parseDouble(sb.toString()));
            }
            if(qName.equals("staff")) {
                staffs.add(buff);
            }

            System.out.println("VALUE " + sb.toString().trim());
            sb = new StringBuilder();
            String out = "END " + qName;
            System.out.println(out);
        }
    }
}
