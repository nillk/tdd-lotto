import lotto.Lotto;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @Before
    public void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    public void 천원당_한_장의_로또를_구매할_수_있다() {
        assertThat(lottoMachine.buy(1000)).isEqualTo(1);
        assertThat(lottoMachine.buy(2000)).isEqualTo(2);
    }

    @Test
    public void 구입_금액은_천원_이상이어야_한다() {
        assertThatExceptionOfType(RuntimeException.class).
                isThrownBy(() -> lottoMachine.buy(600)).
                withMessage("구매 금액은 1000원 이상이어야 합니다.");
    }

    @Test
    public void 천원_단위가_아닌_금액은_버린다() {
        assertThat(lottoMachine.buy(2500)).isEqualTo(2);
        assertThat(lottoMachine.buy(8740)).isEqualTo(8);
    }

    @Test
    public void 구매_금액만큼_로또_번호를_받는다() {
        assertThat(lottoMachine.buy(1000)).isEqualTo(1);

        assertThat(lottoMachine.lottoString(0)).
                isNotBlank().
                asString().containsPattern("\\[([0-9]+, ){5}([0-9]+{1})\\]"); // [1, 2, 3, 4, 5, 6] 형태
    }

    @Test
    public void 지난주_당첨_번호를_입력할_수_있다() {
        lottoMachine.setWinningNumber("1,2,3,4,5,6");

        assertThat(lottoMachine.checkWinning(new Lotto(1, 2, 3, 4, 5, 6))).isTrue();
    }

    @Test
    public void 당첨_번호로_6자리_숫자를_입력하지_않으면_에러가_발생한다() {
        assertThatThrownBy(() -> lottoMachine.setWinningNumber("1,2,3"))
                .hasMessage("로또는 6개의 숫자로 이루어져야 합니다.");

        assertThatThrownBy(() -> lottoMachine.setWinningNumber("1,2,3,4,5,6,7"))
                .hasMessage("로또는 6개의 숫자로 이루어져야 합니다.");
    }
}
