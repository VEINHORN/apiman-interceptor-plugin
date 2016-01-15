package com.veinhorn.plugins.interceptor;

import io.apiman.gateway.engine.beans.ApiRequest;
import org.xml.sax.InputSource;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by veinhorn on 16.1.16.
 */
public class Interceptor {
    public static void intercept(ApiRequest request) {
        String xml = ((HttpServletRequest)request.getRawRequest()).getParameter("xml");
        Data data = convert(convert(xml));
        int a = 0;
    }

    private static Data convert(InputSource is) {
        Data data = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            data = (Data)unmarshaller.unmarshal(is);
            int a = 0;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static InputSource convert(String xml) {
        return new InputSource(new StringReader(xml));
    }
}
