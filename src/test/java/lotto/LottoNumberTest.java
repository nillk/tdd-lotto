package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    public void 숫자가_1보다_작으면_에러가_발생한다() {
        assertThatThrownBy(() -> new LottoNumber(0)).hasMessage("숫자는 1보다 크거나 같아야 합니다.");
    }

    @Test
    public void 숫자가_45보다_크면_에러가_발생한다() {
        assertThatThrownBy(() -> new LottoNumber(46)).hasMessage("숫자는 45보다 작거나 같아야 합니다.");
    }

    @Test
    public void 같은_값을_가지는_LottoNumber는_같아야_한다() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }
}
