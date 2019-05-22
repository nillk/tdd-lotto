package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_COUNT = 6;

    private List<LottoNumber> numbers;

    public Lotto(int... numbers) {
        this(Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> numbers) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}