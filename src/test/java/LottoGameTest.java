import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void 천원당_한_장의_로또를_구매할_수_있다() {
        LottoGame lottoGame = new LottoGame();
        int count = lottoGame.buy(2000);

        assertThat(count).isEqualTo(2);
    }
}
