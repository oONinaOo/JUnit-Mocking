import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilePartReader {

    private String path;
    private int fromLine;
    private int toLine;


    public FilePartReader (String path, int fromLine, int toLine){
        this.path = path;
        this.fromLine = fromLine;
        this.toLine = toLine;

        if(toLine < fromLine || fromLine < 1 ){
            throw new IllegalArgumentException();
        }

    }

    private String read(){
        String result = "";
        Charset charset = Charset.forName("ISO-8859-1");
        try {
            List<String> lines = Files.readAllLines(Paths.get(path), charset);

            for (String line : lines) {
                result += line + "\n";
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return result;
    }


    public String readLines(){
        String lines = read();
        String[] getRows = lines.split("\n");
        String result = "";

        for (int i = fromLine - 1; i < toLine; i++) {
            result += getRows[i] + " ";
        }

        return result;
    }

}
