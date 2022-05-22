import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * File Miner Status Bot
 */
public class FileMSB {

    private static final String CONFIG_PROPERTIES = "src/main/resources/config.properties";
    private static final Properties properties = new Properties();

    public FileMSB() {
        configureProperties();
    }

    public void configureProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream(CONFIG_PROPERTIES);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Файл конфигурации не обнаружен: " + e);
        }
    }

    public List<String> getFileNames(List<File> files) {
        List<String> fileNames = new ArrayList<>();
        files.forEach(file -> fileNames.add(file.getName()));
        return fileNames;
    }

    public void printFileNames(List<String> fileNames) {
        int index = 0;
        for (String fileName : fileNames) {
            System.out.println(index + ". " + fileName);
            index++;
        }
    }

    public List<String> readFile(File file) {
        List<String> content = new ArrayList<>();
        try {
            content.addAll(Files.readAllLines(file.toPath()));
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл: " + file.getName() + " " + e);
        }
        return content;
    }

    public Properties getProperties() {
        return properties;
    }
}
