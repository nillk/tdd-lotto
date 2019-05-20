import lotto.LottoList;

public class LottoGame {

    private static final int PRICE_BASE = 1000;

    private LottoList lottoList;

    public void buy(int price) {
        if (price < PRICE_BASE) {
            throw new RuntimeException("구매 금액은 1000원 이상이어야 합니다.");
        }

        generateLottos(price / PRICE_BASE);
    }

    private void generateLottos(int size) {
        this.lottoList = new LottoList(size);
    }

    public int lottoSize() {
        return lottoList.size();
    }

    public String lottoStringByIndex(int index) {
        return lottoList.lottoString(index);
    }
}