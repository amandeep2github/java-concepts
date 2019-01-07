package learn.java.v8.functional.io;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class FileHandlerTest {

    @Test
    public void getNoOfFile() {
        FileHandler fh = new FileHandler();
        assertThat(fh.getNoOfFile("C:\\X1\\empty\\file.txt.txt")).isEqualTo(0);
    }
}