package lotto;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;

public class LottoTest {

    @Test
    public void 로또는_6개의_숫자로_만들어져야_한다() {
        try {
            new Lotto(Arrays.asList(new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)));
        } catch (Exception e) {
            fail("예외가 발생하지 않아야 함");
        }
    }

    @Test
    public void 로또가_6개의_숫자로_구성되지_않으면_에러_발생() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7)))).hasMessage("로또는 6개의 숫자로 이루어져야 합니다.");

        assertThatThrownBy(() -> new Lotto(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)))).hasMessage("로또는 6개의 숫자로 이루어져야 합니다.");
    }

    @Test
    public void 로또의_6개의_숫자는_중복될_수_없다() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(5)))).hasMessage("중복된 숫자가 있습니다.");
    }
}
