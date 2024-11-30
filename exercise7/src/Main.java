import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {

            System.out.println("---- XML Parsing ----");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDocument = builder.parse(new File("src/Book.xml"));
            XMLHandler.parse(xmlDocument);

            System.out.println("---- After new book to xml ----");


            Element newBook = XMLHandler.createNewXMLBook(xmlDocument, "The Pragmatic Programmer", 1999, 352, new String[]{"Andy Hunt", "Dave Thomas"});
            xmlDocument.getDocumentElement().appendChild(newBook);
            XMLHandler.parse(xmlDocument);


            System.out.println("---- JSON Parsing ----");
            JSONParser parser = new JSONParser();
            JSONObject jsonDocument = (JSONObject) parser.parse(new FileReader("src/Book.json"));
            JSONHandler.parse(jsonDocument);

            System.out.println("---- After new book to json ----");

            JSONObject newJsonBook = JSONHandler.createNewJSONBook("The Pragmatic Programmer", 1999, 352, new String[]{"Andy Hunt", "Dave Thomas"});
            JSONArray bookShelfArray = (JSONArray) jsonDocument.get("bookShelf");
            bookShelfArray.add(newJsonBook);
            JSONHandler.parse(jsonDocument);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}