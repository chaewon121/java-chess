package chess.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    private Position position;

    @BeforeEach
    void setUP() {
        position = new Position(1, 1);
    }

    @Test
    @DisplayName("UnitVector를 받아 Position을 이동한다.")
    void moveTest_up() {
        var movedPosition = position.move(UnitVector.UP);

        assertThat(movedPosition.equals(new Position(0, 1))).isTrue();
    }

    @Test
    @DisplayName("UnitVector를 받아 Position을 이동한다.")
    void moveTest_down() {
        var movedPosition = position.move(UnitVector.DOWN);

        assertThat(movedPosition.equals(new Position(2, 1))).isTrue();
    }

    @Test
    @DisplayName("UnitVector를 받아 Position을 이동한다.")
    void moveTest_left() {
        var movedPosition = position.move(UnitVector.LEFT);

        assertThat(movedPosition.equals(new Position(1, 0))).isTrue();
    }

    @Test
    @DisplayName("UnitVector를 받아 Position을 이동한다.")
    void moveTest_right() {
        var movedPosition = position.move(UnitVector.RIGHT);

        assertThat(movedPosition.equals(new Position(1, 2))).isTrue();
    }
    @Test
    @DisplayName("UnitVector를 받아 Position을 이동한다.")
    void moveTest_upRight() {
        var movedPosition = position.move(UnitVector.UP_RIGHT);

        assertThat(movedPosition.equals(new Position(0, 2))).isTrue();
    }
    @Test
    @DisplayName("UnitVector를 받아 Position을 이동한다.")
    void moveTest_upLeft() {
        var movedPosition = position.move(UnitVector.UP_LEFT);

        assertThat(movedPosition.equals(new Position(0, 0))).isTrue();
    }
    @Test
    @DisplayName("UnitVector를 받아 Position을 이동한다.")
    void moveTest_downLeft() {
        var position = new Position(1, 1);

        var movedPosition = position.move(UnitVector.DOWN_RIGHT);

        assertThat(movedPosition.equals(new Position(2, 2))).isTrue();
    }
    @Test
    @DisplayName("UnitVector를 받아 Position을 이동한다.")
    void moveTest_downRight() {
        var position = new Position(1, 1);

        var movedPosition = position.move(UnitVector.DOWN_LEFT);

        assertThat(movedPosition.equals(new Position(2, 0))).isTrue();
    }

    @Test
    @DisplayName("Position 객체는 논리적으로 같으면 같은 객체이다.")
    void equalsTest() {
        var a = new Position(1, 1);
        var b = new Position(1, 1);

        assertThat(a.equals(b)).isTrue();
    }
}
