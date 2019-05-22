import lotto.LottoList;
import winning.WinningNumber;
import winning.WinningStatistics;

public class LottoMachine {

    private static final int PRICE_BASE = 1000;

    private LottoList lottoList;

    public int buy(int price) {
        if (price < PRICE_BASE) {
            throw new RuntimeException("구매 금액은 1000원 이상이어야 합니다.");
        }

        generateLottos(price / PRICE_BASE);

        return this.lottoList.size();
    }

    private void generateLottos(int size) {
        this.lottoList = new LottoList(size);
    }

    public WinningStatistics check(WinningNumber winningNumber) {
        return this.lottoList.check(winningNumber);
    }

    public String lottoString(int index) {
        return lottoList.lottoString(index);
    }

    public String allLottoString() {
        return lottoList.allLottoString();
    }
}