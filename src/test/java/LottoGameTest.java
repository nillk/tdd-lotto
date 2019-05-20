import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoGameTest {

    private LottoGame lottoGame;

    @Before
    public void setUp() {
        lottoGame = new LottoGame();
    }

    @Test
    public void 천원당_한_장의_로또를_구매할_수_있다() {
        lottoGame.buy(1000);
        assertThat(lottoGame.lottoSize()).isEqualTo(1);

        lottoGame.buy(2000);
        assertThat(lottoGame.lottoSize()).isEqualTo(2);
    }

    @Test
    public void 구입_금액은_천원_이상이어야_한다() {
        assertThatExceptionOfType(RuntimeException.class).
                isThrownBy(() -> lottoGame.buy(600)).
                withMessage("구매 금액은 1000원 이상이어야 합니다.");
    }

    @Test
    public void 천원_단위가_아닌_금액은_버린다() {
        lottoGame.buy(2500);
        assertThat(lottoGame.lottoSize()).isEqualTo(2);

        lottoGame.buy(8740);
        assertThat(lottoGame.lottoSize()).isEqualTo(8);
    }

    @Test
    public void 구매_금액만큼_로또_번호를_받는다() {
        lottoGame.buy(1000);

        assertThat(lottoGame.lottoSize()).isEqualTo(1);

        assertThat(lottoGame.lottoStringByIndex(0)).
                isNotBlank().
                asString().containsPattern("\\[([0-9]+, ){5}([0-9]+{1})\\]"); // [1, 2, 3, 4, 5, 6] 형태
    }
}
