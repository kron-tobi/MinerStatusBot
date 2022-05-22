import java.io.File;
import java.util.*;

public class Main {

    public static final String MINER_LOG_PATH = "miner.log.path";

    public static void main(String[] args) {
        FileMSB fileMSB = new FileMSB();
        Properties properties = fileMSB.getProperties();
        String path = properties.getProperty(MINER_LOG_PATH);
        File folder = new File(path);
        List<File> files = Arrays.asList(Objects.requireNonNull(folder.listFiles()));
        List<String> fileNames = fileMSB.getFileNames(files);
        fileMSB.printFileNames(fileNames);

        File currentFile = files.get(0);
        List<String> content = new ArrayList<>();
        if (currentFile != null && currentFile.canRead()) {
            content.addAll(fileMSB.readFile(currentFile));
        }
        content.forEach(System.out::println);
    }
}
