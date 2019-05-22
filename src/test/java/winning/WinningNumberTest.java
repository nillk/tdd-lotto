package winning;

import lotto.Lotto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningNumberTest {

    @Test
    public void 당첨_번호를_입력할_수_있다() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", "7");

        assertThat(winningNumber.check(new Lotto(1, 2, 3, 4, 5, 6))).isEqualTo(WinningRank.FIRST);
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
        try {
            new WinningNumber("1,2,3,4,5,6", "7");
        } catch (Exception e) {
            fail("에러가 발생하지 않아야 함");
        }

        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "1,2"))
                .hasMessage("보너스 번호는 하나의 숫자여야 합니다.");
    }

    @Test
    public void 보너스_번호가_1에서_45_사이의_숫자가_아니면_에러_발생() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "0"))
                .hasMessage("숫자는 1보다 크거나 같아야 합니다.");

        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "46"))
                .hasMessage("숫자는 45보다 작거나 같아야 합니다.");
    }

    @Test
    public void 보너스_번호가_당첨번호에_있는_숫자면_에러_발생() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "6"))
                .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    public void 모든_번호가_동일하면_1등이다() {
        assertThat(new WinningNumber("1,2,3,4,5,6", "7").check(new Lotto(1, 2, 3, 4, 5, 6)))
                .isEqualTo(WinningRank.FIRST);
    }

    @Test
    public void 번호가_5개_일치하고_보너스_번호가_일치하면_2등이다() {
        assertThat(new WinningNumber("1,2,3,4,5,6", "7").check(new Lotto(1, 2, 3, 4, 5, 7)))
                .isEqualTo(WinningRank.SECOND);
    }

    @Test
    public void 번호가_5개_일치하고_보너스_번호가_일치하지_않으면_3등이다() {
        assertThat(new WinningNumber("1,2,3,4,5,6", "7").check(new Lotto(1, 2, 3, 4, 5, 8)))
                .isEqualTo(WinningRank.THIRD);
    }

    @Test
    public void 번호가_4개_일치하면_4등이다() {
        assertThat(new WinningNumber("1,2,3,4,5,6", "7").check(new Lotto(1, 2, 3, 4, 8, 9)))
                .isEqualTo(WinningRank.FOURTH);
    }

    @Test
    public void 번호가_3개_일치하면_5등이다() {
        assertThat(new WinningNumber("1,2,3,4,5,6", "7").check(new Lotto(1, 2, 3, 8, 9, 10)))
                .isEqualTo(WinningRank.FIFTH);
    }

    @Test
    public void 번호가_3개_이하로_일치하면_당첨되지_않는다() {
        assertThat(new WinningNumber("1,2,3,4,5,6", "7").check(new Lotto(1, 2, 8, 9, 10, 11)))
                .isEqualTo(WinningRank.NONE);
    }
}
