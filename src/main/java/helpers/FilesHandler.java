package helpers;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class FilesHandler {

    public static int countTheFiles(String downloadDir){
        return Objects.requireNonNull(new File(downloadDir).list()).length;
    }

    public static List<File> getTheListOfFiles(String downloadDir){
        return List.of(Objects.requireNonNull(new File(downloadDir).listFiles()));
    }
}
