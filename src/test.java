/**
 * Created by Nikolett on 2017.04.19..
 */
public class test {
    public static void main (String args []){
        FilePartReader reader = new FilePartReader("src/text.txt", 2,3);

        reader.readLines();
        System.out.println(reader.readLines());

        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        analyzer.wordsByABC();
        System.out.println(analyzer.wordsByABC());

        System.out.println(analyzer.wordsContainingSubString("egy"));


    }
}
