import lotto.Lotto;
import lotto.LottoNumber;

import java.util.Arrays;

public class WinningNumber {

    private Lotto winningLotto;
    private LottoNumber bonus;

    public WinningNumber(String winning, String bonus) {
        this.winningLotto = parseWinningString(winning);
        this.bonus = parseBonusString(bonus);

        validateBonus();
    }

    private Lotto parseWinningString(String winning) {
        int[] winningArray = Arrays.stream(winning.split("[ ]*,[ ]*"))
                .mapToInt(Integer::parseInt).toArray();

        return new Lotto(winningArray);
    }

    private LottoNumber parseBonusString(String bonus) {
        try {
            return new LottoNumber(Integer.parseInt(bonus));
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("보너스 번호는 하나의 숫자여야 합니다.");
        }
    }

    private void validateBonus() {
        if (this.winningLotto.contains(bonus)) {
            throw new RuntimeException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public boolean check(Lotto lotto) {
        return this.winningLotto.equals(lotto);
    }
}
