import lotto.Lotto;
import lotto.LottoList;

import java.util.Arrays;

public class LottoMachine {

    private static final int PRICE_BASE = 1000;

    private LottoList lottoList;
    private Lotto winningLotto;

    public int buy(int price) {
        if (price < PRICE_BASE) {
            throw new RuntimeException("구매 금액은 1000원 이상이어야 합니다.");
        }

        generateLottos(price / PRICE_BASE);

        return lottoSize();
    }

    private void generateLottos(int size) {
        this.lottoList = new LottoList(size);
    }

    private int lottoSize() {
        return lottoList.size();
    }

    public void setWinningNumber(String winningNumberString) {
        int[] winnings = Arrays.stream(winningNumberString.split("[ ]*,[ ]*"))
                .mapToInt(Integer::parseInt).toArray();

        this.winningLotto = new Lotto(winnings);
    }

    public boolean checkWinning(Lotto lotto) {
        return this.winningLotto.equals(lotto);
    }

    public String lottoString(int index) {
        return lottoList.lottoString(index);
    }

    public String allLottoString() {
        return lottoList.allLottoString();
    }
}