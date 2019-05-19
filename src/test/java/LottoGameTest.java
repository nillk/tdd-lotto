import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoGameTest {

    @Test
    public void 천원당_한_장의_로또를_구매할_수_있다() {
        LottoGame lottoGame = new LottoGame();

        assertThat(lottoGame.buy(1000)).isEqualTo(1);
        assertThat(lottoGame.buy(2000)).isEqualTo(2);
    }

    @Test
    public void 구입_금액은_천원_이상이어야_한다() {
        LottoGame lottoGame = new LottoGame();

        assertThatExceptionOfType(RuntimeException.class).
                isThrownBy(() -> lottoGame.buy(600)).
                withMessage("구매 금액은 1000원 이상이어야 합니다.");
    }
}
