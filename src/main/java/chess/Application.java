package chess;

import chess.domain.board.Board;
import chess.domain.board.File;
import chess.domain.board.Position;
import chess.domain.board.Rank;
import chess.domain.pieces.Piece;
import chess.domain.pieces.PieceFactory;
import chess.service.ChessGame;
import chess.view.InputView;
import chess.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final ChessGame chessGame = new ChessGame();

    public static void main(String[] args) {
        OutputView.printGameStart();

        while (!chessGame.isEnd()) {
            changeState();
            if (chessGame.isKingDie()) {
                OutputView.printWinner(chessGame.winTeam().getValue());
                chessGame.changeTurnEnd();
                break;
            }
        }

    }

    private static void changeState() {
        try {
            Command command = new Command(InputView.readCommand());
            if (command.isStatus()) {
                OutputView.printScore(chessGame.calculateScore());
                printBoard();
                return;
            }
            if (command.isMove()) {
                chessGame.move(command.getCurrentPosition(), command.getTargetPosition());
                chessGame.changeTurn();
                printBoard();
                return;
            }
            if (command.isStart()) {
                chessGame.start();
                printBoard();
                return;
            }
            if (command.isEnd()) {
                chessGame.changeTurnEnd();
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
            changeState();
        }
    }

    private static void printBoard() {
        List<List<String>> pieceNames = new ArrayList<>();
        for (int rank = 8; rank > 0; rank--) {
            pieceNames.add(addName(chessGame.getBoard(), rank));
        }
        OutputView.printBoard(pieceNames);
    }

    private static List<String> addName(Board board, int rank) {
        List<String> pieceNames = new ArrayList<>();
        for (int file = 0; file < 8; file++) {
            Piece piece = board.getBoard().get(new Position(Rank.of(rank), File.ofByFile(file)));
            pieceNames.add(PieceFactory.from(piece));
        }
        return List.copyOf(pieceNames);
    }
}
