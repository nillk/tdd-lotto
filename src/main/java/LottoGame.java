
public class LottoGame {

    private static final int PRICE_BASE = 1000;

    private int lotto = 0;

    public int buy(int price) {
        if (price < PRICE_BASE) {
            throw new RuntimeException("구매 금액은 1000원 이상이어야 합니다.");
        }

        lotto = price / PRICE_BASE;
        return lotto;
    }
}
