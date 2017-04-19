
public class Mocking extends FilePartReader{

    public Mocking(String path, int fromLine, int toLine) {
        super(path, fromLine, toLine);
    }
    @Override
    public String readLines(){
        return "valamire most változni fog elvileg!";
    }
}