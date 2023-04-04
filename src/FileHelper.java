import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class FileHelper {
    private FileHelper() {}

    public static List<String> openFileAndAddToList(File file){
        List<String> wordList = new ArrayList<>();
        try(Scanner sc = new Scanner(file)){
            while (sc.hasNext()) {
                wordList.add(sc.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not open/find file.");
            return null;
        }
        return wordList;
    }
}
