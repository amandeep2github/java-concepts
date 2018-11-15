package learn.java.v8.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.*;

public class _CollectorsTest {
    @Test
    public void mergeArrayValueInMap(){
        List<String[]> data = Arrays.asList(new String[][]{{"A", "A"},{"A", "pp"},{"A", "le"}});
        BiFunction<String[], Integer, String> valueGetter = (value, index) -> value[index];
        Map<String, String> map = new _Collectors().toMap(data.stream(), valueGetter);
        assertThat(map.get("A")).isEqualTo("Apple");

    }
}