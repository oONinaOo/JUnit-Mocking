import java.util.ArrayList;
import java.util.Collections;

public class FileWordAnalyzer {
    FilePartReader reader;

    public FileWordAnalyzer(FilePartReader reader){
        this.reader = reader;
    }

    public ArrayList <String> wordsByABC(){
        ArrayList<String> sorted = new ArrayList<>();
        String filePart = reader.readLines();
        String[] lineParts = filePart.split(" ");
        for (String word : lineParts) {
            sorted.add(word);
        }
        Collections.sort(sorted, String.CASE_INSENSITIVE_ORDER);

        return sorted;
    }

    public ArrayList wordsContainingSubString(String substring){
        ArrayList<String> containingWords = new ArrayList<>();
        String filePart = reader.readLines();
        String[] lineParts = filePart.split(" ");
        for (String word : lineParts) {
            if (word.contains(substring)) {
                containingWords.add(word);
            }
        }
        return containingWords;
    }

}
