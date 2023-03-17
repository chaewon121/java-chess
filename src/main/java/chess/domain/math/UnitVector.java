package chess.domain.math;

import chess.domain.Position;
import java.util.Arrays;

public enum UnitVector {

    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1),
    UP_RIGHT(-1, 1),
    DOWN_RIGHT(1, 1),
    DOWN_LEFT(1, -1),
    UP_LEFT(-1, -1);

    private final int row;
    private final int col;

    UnitVector(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static UnitVector of(final Position current, final Position target) {
        int rowUnit = unit(target.getRow() - current.getRow());
        int colUnit = unit(target.getCol() - current.getCol());

        return Arrays.stream(UnitVector.values())
                .filter(unitVector -> unitVector.isSame(rowUnit, colUnit))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 방향 벡터 입니다."));
    }

    private static int unit(int input) {
        if (input == 0) {
            return 0;
        }
        return input / Math.abs(input);
    }

    private boolean isSame(final int row, final int col) {
        return this.row == row && this.col == col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}