package com.veinhorn.plugins.interceptor;

import io.apiman.gateway.engine.beans.ApiRequest;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by veinhorn on 16.1.16.
 */
public class Interceptor {
    public static void intercept(ApiRequest request) {
        String xml = ((HttpServletRequest)request.getRawRequest()).getParameter("xml");
        DocumentBuilder documentBuilder = createParser();
        Document document = parseXml(documentBuilder, xml);
    }

    private static DocumentBuilder createParser() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return builder;
    }

    private static Document parseXml(DocumentBuilder documentBuilder, String xml) {
        Document document = null;
        InputSource is = convert(xml);
        try {
            document = documentBuilder.parse(is);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    private static InputSource convert(String xml) {
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xml));
        return is;
    }
}
