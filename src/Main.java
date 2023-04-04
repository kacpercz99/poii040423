import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        zad1();
        WordCounter.printWords(new File("src/res/z2.txt"));
    }

    public static void zad1() {
        File z1 = new File("src/res/z1.txt");
        Map<String, String> mapOfCountriesAndCapitals = new HashMap<>();
        try (Scanner sc = new Scanner(z1)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splitLine = line.trim().split("/");
                mapOfCountriesAndCapitals.put(splitLine[0], splitLine[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        System.out.println("HashMap from File:");
        System.out.println(mapOfCountriesAndCapitals);
        Map<String, String> sortedMap = new TreeMap<>(mapOfCountriesAndCapitals);
        System.out.println("Sorted treeMap, naturalOrder");
        System.out.println(sortedMap);
        Map<String, String> reverseSortedMap = new TreeMap<>(Collections.reverseOrder());
        reverseSortedMap.putAll(sortedMap);
        System.out.println("reverseSorted treeMap:");
        System.out.println(reverseSortedMap);
        final Iterator<Map.Entry<String, String>> iterator = mapOfCountriesAndCapitals.entrySet().iterator();
        System.out.println("Found keys,value pairs with 'r':");
        while (iterator.hasNext()) {
            Map.Entry<String, String> e = iterator.next();
            if (e.getKey().contains("r")) {
                System.out.printf("Key: %s, Value: %s\n", e.getKey(), e.getValue());
                iterator.remove();
            }
        }
        ;
        System.out.println("HashMap of countries and capitals after removing entries with 'r' containing keys:");
        System.out.println(mapOfCountriesAndCapitals);
    }
}