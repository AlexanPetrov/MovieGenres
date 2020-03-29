import java.util.*;

public class Movies {
    private LinkedList<Movie> list; // Complete list of uncleaned data
    private LinkedList<String> titles = new LinkedList<>(); // Titles unsorted (including years)
    private LinkedList<String> genres = new LinkedList<>(); // Genres list 
    TreeMap<String, String> titleYearMap = new TreeMap<>(); // Title/year map sorted by  title
    TreeMap<String, String> yearTitleMap = new TreeMap<>(); // Year/title map sorted by year
    public Movies() { // Constructor
        list = new LinkedList<Movie>();
    }
    public void countGenres() { // Genre conter 
        int thriller = 0, horror = 0, comedy = 0, adventure = 0, action = 0, romance = 0,
            animation = 0, documentary = 0, mixed = 0, total = 0, average = 0;
        for (String genre : genres) {
            total++;
            if (genre.equals("Thriller")) {
                thriller++;
            }
            if (genre.equals("Horror")) {
                horror++;
            }
            if (genre.equals("Comedy")) {
                comedy++;
            }
            if (genre.equals("Adventure")) {
                adventure++;
            }
            if (genre.equals("Action")) {
                action++;
            }
            if (genre.equals("Romance")) {
                romance++;
            }
            if (genre.equals("Animation")) {
                animation++;
            }
            if (genre.equals("Documentary")) {
                documentary++;
            }
            if (!(genre.equals("Thriller"))) {
                mixed++;
            }
            if (!(genre.equals("Horror"))) {
                mixed++;
            }
            if (!(genre.equals("Comedy"))) {
                mixed++;
            }
            if (!(genre.equals("Adventure"))) {
                mixed++;
            }
            if (!(genre.equals("Action"))) {
                mixed++;
            }
            if (!(genre.equals("Romance"))) {
                mixed++;
            }
            if (!(genre.equals("Animation"))) {
                mixed++;
            }
            if (!(genre.equals("Documentary"))) {
                mixed++;
            }
        }
        average = total / 9;
        System.out.println("Average Movie Count per Genre: " + average);
        System.out.println("Thrillers: " + thriller + "\nHorrors: " + horror + "\nComedies: " + 
                            comedy + "\nAdventures: " + adventure + "\nActions: " + action +
                            "\nRomances: " + romance + "\nAnimations: " + animation +
                            "\nDocumentaries: " + documentary + "\nMixed: " + mixed);
    }
    public void convert1(ArrayList<ArrayList<String>> array) {
        LinkedList<Movie> movies = new LinkedList<>();
        for (ArrayList<String> row : array) { // Converter from arrayList to linkedList
            int ID = Integer.parseInt(row.get(0));
            String title = row.get(1);
            titles.add(title);
            String genre = row.get(2);
            genres.add(genre);
            Movie movie = new Movie(ID, title, genre);
            movies.add(movie);
        }
        list = movies;
    }
    public void convert2() { 
        String s = ""; // Converter from linkedLists to treeMap
        String n = "";
        String l = "";
        for (int i = 0; i < titles.size(); i++) {
            s = titles.get(i);
            n = s.replaceAll("[^0-9]", "");
            l = s.replaceAll("[0-9()]", "");
            titleYearMap.put(l, n);
        }
    } 
    public void yearSort() { // Sort treeMap by year
        String str = "";
        String subStr = "";
        String subStr1 = "";
        String year = "";
        String name = "";
        LinkedList<String> years = new LinkedList<>();
        LinkedList<String> names = new LinkedList<>();
        for (int k = 0; k < titles.size(); k++) {
            str = titles.get(k);
            if (str.length() > 6) {
                subStr = str.substring(str.length()-6);
                subStr1 = str.substring(0, str.length()-6);
                year = subStr.substring(1, 5);
                years.add(year);
                names.add(subStr1);
            }
            else {
                subStr = str;
                year = subStr;
                subStr1 = str;
                years.add(year);
                names.add(name);
            }
            //System.out.println(year + " " + subStr1);
            yearTitleMap.put(year, subStr1);
            // Be sure to have most recent version of Java 8 installed to be able to view numeric
            // values properly. Otherwise, the 'year' values will be displayed as chars. 
        }
    }
    public LinkedList<Movie> getList() {
        return list; // List getter
    }
    public void printTitles() { // Prints unsorted and attached to years titles
        for (String title : titles) {
            System.out.println(title + " ");
        }
    }
    public void printList() { // List printer
        for (Movie m : list) {
            System.out.println(m + " ");
        }
    }
    public void printTitleYearMap() { // Map printer title/year
        for (Map.Entry<String, String> entry : titleYearMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    public void printYearTitleMap() { // Map printer year/title
        for (Map.Entry<String, String> entry : yearTitleMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    // 
    public void sortList() { // List sorter
        Collections.sort(list);
    }
    //
    public class Movie implements Comparable {
        private int ID;
        private String title;
        private String genre;
        public Movie() { // Constructor
            this(0, " ", " ");
        }
        public Movie(int ID, String title, String genre) {
            this.ID = ID; // Constructor
            this.title = title;
            this.genre = genre;
        }
        @Override
        public String toString() { // toString overridden
            return ID +" "+ title +" "+ genre;
        }
        @Override
        public int compareTo(Object o) { // compareTo overridden 
            Movie other = (Movie) o;
            int compared = this.genre.compareTo(other.genre);
            return compared;
        }
    }
}
