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
}
