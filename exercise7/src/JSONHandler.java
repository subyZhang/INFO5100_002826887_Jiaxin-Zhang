import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONHandler {
    public static void parse(JSONObject jsonDoc) {
        JSONArray books = (JSONArray) jsonDoc.get("bookShelf");
        for (Object obj : books) {
            JSONObject book = (JSONObject) obj;
            System.out.println("Title: " + book.get("title") +
                    ", Year: " + book.get("publishedYear") +
                    ", Pages: " + book.get("numberOfPages"));
            System.out.print("Authors: ");
            JSONArray authors = (JSONArray) book.get("authors");
            for (int j = 0; j < authors.size(); j++) {
                System.out.print(authors.get(j) + (j < authors.size() - 1 ? ", " : ""));
            }
            System.out.println("\n");
        }
    }

    public static JSONObject createNewJSONBook(String title, int year, int pages, String[] authors) {
        JSONObject newBook = new JSONObject();
        newBook.put("title", title);
        newBook.put("publishedYear", year);
        newBook.put("numberOfPages", pages);

        JSONArray authorsArray = new JSONArray();
        for (String author : authors) {
            authorsArray.add(author);
        }
        newBook.put("authors", authorsArray);

        return newBook;
    }
}
