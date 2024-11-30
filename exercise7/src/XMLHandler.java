import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLHandler {
    public static void parse(Document document) {
        NodeList books = document.getElementsByTagName("book");
        for (int i = 0; i < books.getLength(); i++) {
            Node book = books.item(i);
            if (book.getNodeType() == Node.ELEMENT_NODE) {
                Element bookElement = (Element) book;
                String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                String year = bookElement.getElementsByTagName("publishedYear").item(0).getTextContent();
                String pages = bookElement.getElementsByTagName("numberOfPages").item(0).getTextContent();
                NodeList authors = bookElement.getElementsByTagName("author");
                System.out.println("Title: " + title + ", Year: " + year + ", Pages: " + pages);
                System.out.print("Authors: ");
                for (int j = 0; j < authors.getLength(); j++) {
                    System.out.print(authors.item(j).getTextContent() + (j < authors.getLength() - 1 ? ", " : ""));
                }
                System.out.println("\n");
            }
        }
    }

    public static Element createNewXMLBook(Document doc, String title, int year, int pages, String[] authors) {
        Element book = doc.createElement("book");

        Element titleElement = doc.createElement("title");
        titleElement.appendChild(doc.createTextNode(title));
        book.appendChild(titleElement);

        Element yearElement = doc.createElement("publishedYear");
        yearElement.appendChild(doc.createTextNode(Integer.toString(year)));
        book.appendChild(yearElement);

        Element pagesElement = doc.createElement("numberOfPages");
        pagesElement.appendChild(doc.createTextNode(Integer.toString(pages)));
        book.appendChild(pagesElement);

        Element authorsElement = doc.createElement("authors");
        for (String author : authors) {
            Element authorElement = doc.createElement("author");
            authorElement.appendChild(doc.createTextNode(author));
            authorsElement.appendChild(authorElement);
        }
        book.appendChild(authorsElement);

        return book;
    }
}
