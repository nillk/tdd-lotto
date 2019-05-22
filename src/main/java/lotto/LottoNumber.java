package lotto;

import java.util.Objects;
import java.util.Random;

public class LottoNumber {

    private static final int NUM_BOUND = 45;

    private int number;

    public LottoNumber(int number) {
        if (number < 1) {
            throw new RuntimeException("숫자는 1보다 크거나 같아야 합니다.");
        }

        if (number > NUM_BOUND) {
            throw new RuntimeException("숫자는 45보다 작거나 같아야 합니다.");
        }

        this.number = number;
    }

    static LottoNumber generate() {
        Random random = new Random();
        return new LottoNumber(random.nextInt(NUM_BOUND) + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
