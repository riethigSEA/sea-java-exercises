package quests.fileio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileHandling {

    public static void main(String[] args) throws IOException {
        File kcsv = new File("/Users/marco/IdeaProjects/sea-java-exercises/src/test/resources/kunden.csv");
        List<String> inputList = Files.readAllLines(kcsv.toPath());
        List<Kunde> kundenListe =  new ArrayList<>();

        for(int i = 0; i < inputList.size(); i++){

            String[] kundeArray = inputList.get(i).split(",");
            kundenListe.add(new Kunde(kundeArray[0],kundeArray[1],kundeArray[2]));

        }
        System.out.println(searchForId(kundenListe, "TMU55QLK9BT"));
        writeSortedKunden(sortKunden(kundenListe));



        // Use NIO for file reading, the NIO static utility method Files.readAllLines
        // returns a List<String> of all lines in the file, each line one entry of the list
        // 2. Split each line into a String array, use the correct separator string ",".
        // Each line consists of "id,name,email" of a Kunde.

        // 3. Convert each line into an object of class Kunde, which already has a suitable constructor (id,name,email)

        // 4. Add all Kunde objects to a new List<Kunde>

        // 5. In this FileHandling class, create a static method searchForId which takes the List<Kunde> and a String searchId, searches for the Kunde with this searchId as ID and returns the name

        // 6. (Opt.) In this class, create a static method sortKunden which takes the List<Kunde>, sorts this list for the names and returns the sorted List<Kunde>

        // 7. (Opt.) Write the sorted list to a new File("src/test/resources/sorted_kunden.csv"), you can use the writeSortedKunden method. To see the file in the IDE you might have to "reload all files from disk".

        // 8. Push all your changes to your fork of the repo
    }

    public static String searchForId(List<Kunde> kunden, String id) {
        // Iterate through the list, search for the id and return the name if found.
        for(Kunde kunde : kunden) {
            if (kunde.getId().equals(id)) {
                return kunde.getName();
            }


        }
        return null;

    }


    public static List<Kunde> sortKunden(List<Kunde> kunden) {

        kunden.sort(Comparator.comparing(Kunde::getName));
        for ( Kunde kunde : kunden){
            System.out.println(kunde.getName());
        }
        return kunden;
    }

    public static void writeSortedKunden(List<Kunde> lines) throws IOException {
        File out = new File("src/test/resources/sorted_kunden.csv");
        FileWriter writer = new FileWriter(out, true);
        for(Kunde kunde : lines) {


            writer.write(kunde.getId()+","+kunde.getName()+","+kunde.getEmail()+ System.lineSeparator());

        }
        writer.close();
        // Write each line to the file. If it looks funny, maybe you have to add a line separator (System.lineSeparator())
    }
}
