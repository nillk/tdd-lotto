package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoList {

    private List<Lotto> lottoList;

    public LottoList(int count) {
        this.lottoList = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            lottoList.add(Lotto.generate());
        }
    }

    public int size() {
        return lottoList.size();
    }

    public String lottoString(int index) {
        return lottoList.get(index).toString();
    }

    public String allLottoString() {
        return lottoList.stream().
                map(Lotto::toString).
                collect(Collectors.joining(System.lineSeparator()));
    }
}