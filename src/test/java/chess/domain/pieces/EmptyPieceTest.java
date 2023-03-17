package chess.domain.pieces;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import chess.domain.Team;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmptyPieceTest {

    @Test
    @DisplayName("EmptyPiece는 Neutrality 팀만을 가진다.")
    void validateTeamTest_exception() {
        Team team = Team.BLACK;

        assertThatIllegalArgumentException().isThrownBy(
                () -> new EmptyPiece(team)
        ).withMessage(EmptyPiece.INVALID_TEAM + team);
    }

    @Test
    @DisplayName("EmptyPiece는 Neutrality 팀만을 가진다.")
    void validateTeamTest_success() {
        Team team = Team.NEUTRALITY;

        assertThatNoException().isThrownBy(
                () -> new EmptyPiece(team)
        );
    }
}