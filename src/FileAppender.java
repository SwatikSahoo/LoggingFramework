import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender {
    private final String path;

    public FileAppender(String path) {
        this.path = path;
    }
    public void append(LogMessage msg){
        try(FileWriter writer= new FileWriter(path, true)){
            writer.write(msg.toString()+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
