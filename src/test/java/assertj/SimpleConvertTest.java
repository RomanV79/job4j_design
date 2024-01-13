package assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .contains("three")
                .containsAnyOf("nine", "ten", "first")
                .contains("five", Index.atIndex(4))
                .containsOnlyOnce("three")
                .containsSequence("first", "second", "three", "four", "five");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        Set<String> set2 = simpleConvert.toSet("second", "first", "three", "four", "five");
        assertThat(set).hasSize(5)
                .contains("three", "five")
                .containsAnyOf("nine", "ten", "four")
                .containsAll(set2)
                .filteredOn(item -> item.contains("f"))
                .containsOnly("first", "four", "five");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsKey("second")
                .containsValue(3)
                .containsEntry("four", 3)
                .doesNotContainKey("ten")
                .doesNotContainValue(9);
    }

}