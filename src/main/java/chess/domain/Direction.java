package chess.domain;

import chess.domain.board.Position;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Direction {
    UP(Direction::isUp),
    DOWN(Direction::isDown),
    LEFT(Direction::isLeft),
    RIGHT(Direction::isRight),
    UP_LEFT(Direction::isUpLeft),
    UP_RIGHT(Direction::isUpRight),
    DOWN_LEFT(Direction::isDownLeft),
    DOWN_RIGHT(Direction::isDownRight),
    KNIGHT(Direction::isKnight);

    private final BiPredicate<Position, Position> direction;

    Direction(BiPredicate<Position, Position> direction) {
        this.direction = direction;
    }

    public static Direction findDirection(final Position current, final Position target) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.direction.test(current, target))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 갈 수 없는 방향입니다."));
    }

    private static boolean isUp(final Position current, final Position target) {
        int rankDifferent = target.getRank() - current.getRank();
        int fileDifferent = target.getFile() - current.getFile();
        return rankDifferent > 0 && fileDifferent == 0;
    }

    private static boolean isDown(final Position current, final Position target) {
        int rankDifferent = target.getRank() - current.getRank();
        int fileDifferent = target.getFile() - current.getFile();
        return rankDifferent < 0 && fileDifferent == 0;
    }

    private static boolean isLeft(final Position current, final Position target) {
        int rankDifferent = target.getRank() - current.getRank();
        int fileDifferent = target.getFile() - current.getFile();
        return rankDifferent == 0 && fileDifferent < 0;
    }

    private static boolean isRight(final Position current, final Position target) {
        int rankDifferent = target.getRank() - current.getRank();
        int fileDifferent = target.getFile() - current.getFile();
        return rankDifferent == 0 && fileDifferent > 0;
    }

    private static boolean isUpLeft(final Position current, final Position target) {
        int rankDifferent = target.getRank() - current.getRank();
        int fileDifferent = target.getFile() - current.getFile();
        return Math.abs(rankDifferent) == Math.abs(fileDifferent) && rankDifferent > 0 && fileDifferent < 0;
    }

    private static boolean isUpRight(final Position current, final Position target) {
        int rankDifferent = target.getRank() - current.getRank();
        int fileDifferent = target.getFile() - current.getFile();
        return Math.abs(rankDifferent) == Math.abs(fileDifferent) && rankDifferent > 0 && fileDifferent > 0;
    }

    private static boolean isDownLeft(final Position current, final Position target) {
        int rankDifferent = target.getRank() - current.getRank();
        int fileDifferent = target.getFile() - current.getFile();
        return Math.abs(rankDifferent) == Math.abs(fileDifferent) && rankDifferent < 0 && fileDifferent < 0;
    }

    private static boolean isDownRight(final Position current, final Position target) {
        int rankDifferent = target.getRank() - current.getRank();
        int fileDifferent = target.getFile() - current.getFile();
        return Math.abs(rankDifferent) == Math.abs(fileDifferent) && rankDifferent < 0 && fileDifferent > 0;
    }

    private static boolean isKnight(final Position current, final Position target) {
        int rankDifferent = Math.abs(target.getRank() - current.getRank());
        int fileDifferent = Math.abs(target.getFile() - current.getFile());
        return (rankDifferent == 2 && fileDifferent == 1) || (rankDifferent == 1 && fileDifferent == 2);
    }
}
