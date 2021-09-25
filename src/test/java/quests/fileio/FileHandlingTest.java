package quests.fileio;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileHandlingTest {

    @Test
    public void testSearchForId() {
        List<Kunde> kunden = new ArrayList<>();
        Kunde kunde1 = new Kunde("LBY63IQV6TV", "Mary Mckenzie", "mary@mckenzie.org");
        Kunde kunde2 = new Kunde("LBY63IQV6TA", "Anna Mckenzie", "anna@mckenzie.org");
        kunden.add(kunde1);
        kunden.add(kunde2);
        assertEquals("Mary Mckenzie", FileHandling.searchForId(kunden, "LBY63IQV6TV"));
        assertEquals("Anna Mckenzie", FileHandling.searchForId(kunden, "LBY63IQV6TA"));
    }

    @Test
    // This test is for the optional sorting of the kundendaten.
    public void testSortKunden() {
        List<Kunde> kunden = new ArrayList<>();
        Kunde kunde1 = new Kunde("LBY63IQV6TV", "Mary Mckenzie", "mary@mckenzie.org");
        Kunde kunde2 = new Kunde("LBY63IQV6TZ", "Anna Mckenzie", "anna@mckenzie.org");
        Kunde kunde3 = new Kunde("LBY63IQV6TA", "Zed Mckenzie", "zed@mckenzie.org");
        kunden.add(kunde1);
        kunden.add(kunde2);
        kunden.add(kunde3);
        assertEquals("Mary Mckenzie", kunden.get(0).getName());
        List<Kunde> sortedList = FileHandling.sortKunden(kunden);
        assertEquals("Anna Mckenzie", sortedList.get(0).getName());
        assertEquals("Zed Mckenzie", sortedList.get(2).getName());
    }

    @Test
    // This test is for the optional task of writing a sorted file.
    public void testReadSortedKundendatei() throws IOException {
        File input = new File("src/test/resources/sorted_kunden.csv");
        List<String> lines = Files.readAllLines(input.toPath());
        List<Kunde> kunden = new ArrayList<>();
        for (String string : lines) {
            String[] content = string.split(",");
            Kunde kunde = new Kunde(content[0], content[1], content[2]);
            kunden.add(kunde);
        }
        assertEquals("Adrienne Goodman", kunden.get(0).getName());
        assertEquals("Whoopi Preston", kunden.get(kunden.size()-1).getName());
    }
}
