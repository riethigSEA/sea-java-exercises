package quests.fileio;

import java.io.File;

public class FileHandling {

    public static void main(String[] args) {
        // 1. Read file from new File("src/test/resources/kunden.csv")
        File input = new File("src/test/resources/kunden.csv");
        // 2. Split each line into a String array, use the correct separator character
        // 3. Convert each line into an object of class Kunde
        // 4. Add all Kunde objects to a new List<Kunde>
        // 5. In this class, create a static method which takes the List<Kunde> and a String searchId, searches for the Kunde with this searchId as ID and returns the name
        // 6. (Opt.) In this class, create a static method which takes the List<Kunde>, sorts this list for the names and returns the sorted List<Kunde>
        // 7. (Opt.) Write the sorted list to a new file of your choice (eg. new File("src/test/resources/sorted_kunden.csv"))
        // 8. Push all your changes to your fork of the repo
    }
}
