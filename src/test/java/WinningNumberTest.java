import lotto.Lotto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @Test
    public void 당첨_번호를_입력할_수_있다() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", "7");

        assertThat(winningNumber.check(new Lotto(1, 2, 3, 4, 5, 6))).isTrue();
    }

    @Test
    public void 당첨_번호로_6자리_숫자를_입력하지_않으면_에러가_발생한다() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3", "7"))
                .hasMessage("로또는 6개의 숫자로 이루어져야 합니다.");

        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6,7", "7"))
                .hasMessage("로또는 6개의 숫자로 이루어져야 합니다.");
    }

    @Test
    public void 당첨_번호가_각각_1에서_45_사이의_숫자가_아니면_에러_발생() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,0", "7"))
                .hasMessage("숫자는 1보다 크거나 같아야 합니다.");

        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,46", "7"))
                .hasMessage("숫자는 45보다 작거나 같아야 합니다.");
    }

    @Test
    public void 당첨_번호의_각_숫자는_중복될_수_없다() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,1", "7"))
                .hasMessage("중복된 숫자가 있습니다.");
    }

    @Test
    public void 보너스_번호는_하나의_숫자를_입력해야_한다() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "1,2"))
                .hasMessage("보너스 번호는 하나의 숫자여야 합니다.");
    }
}
