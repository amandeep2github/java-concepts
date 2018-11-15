package learn.java.v8.streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _Collectors {

    public Map<String, String> toMap(Stream<String[]> stream, BiFunction<String[], Integer, String> valueGetter){
        return stream.collect(Collectors.toMap(value -> valueGetter.apply(value, 0), value -> valueGetter.apply(value, 1),
                (oldValue, newValue) -> oldValue + newValue, LinkedHashMap::new));
    }

}
