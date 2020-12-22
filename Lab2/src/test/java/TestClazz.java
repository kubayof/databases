import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestClazz {
    @Test
    public void test1() {
        Map<Integer, Integer> map = new HashMap<>();

        System.out.println(map.compute(1, (k, v) -> 1));
        System.out.println(map.compute(1, (k, v) -> 2));
    }
}
