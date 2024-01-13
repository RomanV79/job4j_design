package assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkWrongFormat() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("key1value1", "key2=value2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("the symbol");

    }

    @Test
    void checkHaveKey() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("key1=value1", "=value2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("a key");
    }

    @Test
    void checkHaveValue() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("key1=value1", "key2="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("a value");
    }

    @Test
    void checkEmptyNames() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("is empty");
    }

}