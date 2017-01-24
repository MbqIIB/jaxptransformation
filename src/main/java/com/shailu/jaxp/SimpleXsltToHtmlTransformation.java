package com.shailu.jaxp;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

/**
 * Created by Shailesh on 1/24/2017.
 */
public class SimpleXsltToHtmlTransformation {

    public static void main(String[] args) {
        File stylesheet = new File("src/main/resources/XsltToHtmlXslt.xsl");
        File dataFile = new File("src/main/resources/XsltToHtmlSource.xml");

        try {
            // Parser for XML document.
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(dataFile);

            // Get an instance of the Transformer for the stylesheet.
            StreamSource stylesource = new StreamSource(stylesheet);
            Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
