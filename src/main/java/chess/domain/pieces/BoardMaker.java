package chess.domain.pieces;

import static java.util.stream.Collectors.toList;

import chess.domain.Position;
import chess.domain.Team;
import chess.domain.board.Rank;
import chess.domain.board.Square;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BoardMaker {

    private static final int START_MIDDLE_ROW = 2;
    private static final int END_MIDDLE_ROW = 5;

    private BoardMaker() {}

    public static List<Rank> create() {
        List<Rank> ranks = new ArrayList<>();

        ranks.add(createFirstRank());
        ranks.add(createSecondRank());
        for (int row = START_MIDDLE_ROW; row <= END_MIDDLE_ROW; row++) {
            ranks.add(createMiddleRank(row));
        }
        ranks.add(createSecondLastRank());
        ranks.add(createLastRank());

        return ranks;
    }

    private static Rank createFirstRank() {
        List<Square> squares = new ArrayList<>(List.of(
                new Square(new Position(0, 0), new Rook(Team.BLACK)),
                new Square(new Position(0, 1), new Knight(Team.BLACK)),
                new Square(new Position(0, 2), new Bishop(Team.BLACK)),
                new Square(new Position(0, 3), new Queen(Team.BLACK)),
                new Square(new Position(0, 4), new King(Team.BLACK)),
                new Square(new Position(0, 5), new Bishop(Team.BLACK)),
                new Square(new Position(0, 6), new Knight(Team.BLACK)),
                new Square(new Position(0, 7), new Rook(Team.BLACK))
        ));

        return new Rank(squares);
    }

    private static Rank createSecondRank() {
        List<Square> squares = IntStream.range(0, 8)
                .mapToObj(col -> new Square(new Position(1, col), new Pawn(Team.BLACK)))
                .collect(toList());

        return new Rank(squares);
    }

    private static Rank createMiddleRank(int row) {
        List<Square> squares = IntStream.range(0, 8)
                .mapToObj(col -> new Square(new Position(row, col), new EmptyPiece()))
                .collect(toList());

        return new Rank(squares);
    }

    private static Rank createSecondLastRank() {
        List<Square> squares = IntStream.range(0, 8)
                .mapToObj(col -> new Square(new Position(6, col), new Pawn(Team.WHITE)))
                .collect(toList());

        return new Rank(squares);
    }

    private static Rank createLastRank() {
        List<Square> squares = new ArrayList<>(List.of(
                new Square(new Position(7, 0), new Rook(Team.WHITE)),
                new Square(new Position(7, 1), new Knight(Team.WHITE)),
                new Square(new Position(7, 2), new Bishop(Team.WHITE)),
                new Square(new Position(7, 3), new Queen(Team.WHITE)),
                new Square(new Position(7, 4), new King(Team.WHITE)),
                new Square(new Position(7, 5), new Bishop(Team.WHITE)),
                new Square(new Position(7, 6), new Knight(Team.WHITE)),
                new Square(new Position(7, 7), new Rook(Team.WHITE))
        ));

        return new Rank(squares);
    }
}
