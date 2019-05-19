
public class LottoGame {

    private static final int PRICE = 1000;

    private int lotto = 0;

    public int buy(int i) {
        lotto = i / PRICE;
        return lotto;
    }
}
