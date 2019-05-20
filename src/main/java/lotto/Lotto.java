package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int LOTTO_COUNT = 6;

    private List<LottoNumber> numbers;

    Lotto(List<LottoNumber> numbers) {
        checkSize(numbers);
        checkDuplication(numbers);

        this.numbers = numbers;
    }

    static Lotto generate() {
        List<LottoNumber> numbers = new ArrayList<>(LOTTO_COUNT);

        for (int i = 0; i < LOTTO_COUNT; i++) {
            LottoNumber num = getUniqueLottoNumber(numbers);

            numbers.add(num);
        }

        return new Lotto(numbers);
    }

    private static LottoNumber getUniqueLottoNumber(List<LottoNumber> numbers) {
        LottoNumber num = LottoNumber.generate();

        while (numbers.contains(num)) {
            num = LottoNumber.generate();
        }

        return num;
    }

    private void checkDuplication(List<LottoNumber> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_COUNT) {
            throw new RuntimeException("중복된 숫자가 있습니다.");
        }
    }

    private void checkSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new RuntimeException("로또는 6개의 숫자로 이루어져야 합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}