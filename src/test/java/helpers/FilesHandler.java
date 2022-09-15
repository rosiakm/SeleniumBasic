package helpers;

import java.io.File;
import java.util.List;
import java.util.Objects;

import static base.TestBase.getDownloadDir;

public class FilesHandler {

    public static int countTheFiles(){
        return Objects.requireNonNull(new File(getDownloadDir()).list()).length;
    }

    public static List<File> getTheListOfFiles(){
        return List.of(Objects.requireNonNull(new File(getDownloadDir()).listFiles()));
    }
}
