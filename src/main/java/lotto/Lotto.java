package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int LOTTO_COUNT = 6;

    List<LottoNumber> numbers;

    Lotto(List<LottoNumber> numbers) {
        checkSize(numbers);

        this.numbers = numbers;
    }

    static Lotto generate() {
        List<LottoNumber> numbers = new ArrayList<>(LOTTO_COUNT);

        for (int i = 0; i < LOTTO_COUNT; i++) {
            numbers.add(LottoNumber.generate());
        }

        return new Lotto(numbers);
    }

    private void checkSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new RuntimeException("로또는 6개의 숫자로 이루어져야 합니다.");
        }
    }
}