package learn.java.v8.functional.io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileHandler {
    public long getNoOfFile(String dirPath){
        //Files.find(Paths.get(dirPath)., 1)
        File file = new File(dirPath);
        System.out.println(file.getAbsolutePath());
        if(!file.exists() || !file.isDirectory())
            return 0;
        return Arrays.stream(file.listFiles()).count();
    }

}
