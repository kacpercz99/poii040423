import java.io.File;
import java.util.*;

public final class WordCounter {
    private WordCounter(){}
    public static void printWords(File file) {
        assert file != null;
        List<String> wordList = FileHelper.openFileAndAddToList(file);
        assert wordList != null;
        System.out.println(calculateWords(wordList));
    }

    private static Map<String, Integer> calculateWords(List<String> listOfWords) {
        Map<String, Integer> wordMap = new TreeMap<>();
        listOfWords.forEach(word -> wordMap.compute(word, (k, v) -> v == null ? 1 : v + 1));
        return wordMap;
    }
}
