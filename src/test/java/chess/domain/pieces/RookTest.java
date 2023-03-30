package chess.domain.pieces;

import chess.domain.pieces.component.Team;
import chess.domain.pieces.component.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RookTest {

    @Test
    @DisplayName("비숍의 팀을 검증한다.")
    void validateTeamTest_exception() {
        Team team = Team.NEUTRALITY;

        assertThatThrownBy(() -> new Rook(team, Type.BISHOP));
    }
}
