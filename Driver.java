import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) throws IOException {      
        
        Stack<String> stack = new Stack<>(); // Init stack for files
        stack.add("movies.csv"); // Add file/s to stack
        
        ArrayList<ArrayList<String>> array = new ArrayList<>(); // Init arrayList
        for (int i = 0; i < stack.size(); i++) {
            try (Scanner sc = new Scanner(new File(stack.get(i)))) {
                while (sc.hasNextLine()) { // Add data from file/s to arrayList (Part I)
                    array.add(toTokens(sc.nextLine()));
                }
            }
        }
        
        // Functinal calls:
        Movies movies = new Movies(); // Init object
        movies.convert1(array); // Convert arrayList to linkedList
        movies.convert2(); // Convert linkedLists (title/year) to treeMap(key/value)
        
        movies.sortList(); // Sort complete list
        movies.printList(); // Print complete list

        movies.printTitleYearMap(); // Title/year printer sorted by title
        movies.countGenres(); // Genere counter and printer

        movies.printTitles(); // Title/Year printer unsorted

        movies.yearSort(); // Year/title sorter (by year)
        movies.printYearTitleMap(); // Year/title printer (sorted by year)

        File file = new File("input.csv"); // Trasfer complete data to input file
        try (PrintWriter pw = new PrintWriter(file)) {
            LinkedList<Movies.Movie> list = movies.getList();
            for (int i = 0; i < list.size(); i++) {
                pw.println(list.get(i));
            }
        }
    }
    public static ArrayList<String> toTokens(String line) {
        ArrayList<String> array = new ArrayList<String>();
        try (Scanner sc = new Scanner(line)) {
            sc.useDelimiter(","); // Add data from file/s to arrayList (Part II)
            while (sc.hasNext()) {
                array.add(sc.next());
            }
            return array;
        }
    }
}
