package assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isNotTriangle() {
        Box box = new Box(2, 2);
        String name = box.whatsThis();
        assertThat(name).isNotEqualTo("Triangle");
    }

    @Test
    void hasFourVertices() {
        Box box = new Box(4, 3);
        int vertexQnt = box.getNumberOfVertices();
        assertThat(vertexQnt).isEqualTo(4);
    }

    @Test
    void hasNotThreeVertices() {
        Box box = new Box(5, 3);
        int vertexQnt = box.getNumberOfVertices();
        assertThat(vertexQnt).isNotEqualTo(3);
    }

    @Test
    void isObjectExist() {
        Box box = new Box(0, 1);
        boolean exist = box.isExist();
        assertThat(exist).isTrue();
    }

    @Test
    void isObjectNotExist() {
        Box box = new Box(2, 2);
        boolean exist = box.isExist();
        assertThat(exist).isFalse();
    }

    @Test
    void areaIsMoreThanZero() {
        Box box = new Box(8, 8);
        double square = box.getArea();
        assertThat(square > 0).isTrue();
    }

    @Test
    void areaIsZero() {
        Box box = new Box(3, 8);
        double square = box.getArea();
        assertEquals(0, square, 0.01);
    }
}