package winning;

public enum WinningRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000) {
        @Override
        public String toString() {
            return this.criteria + "개 일치, 보너스 볼 일치(" + this.prizeMoney + "원)";
        }
    },
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(2, 0);

    int criteria;
    int prizeMoney;

    WinningRank(int criteria, int prizeMoney) {
        this.criteria = criteria;
        this.prizeMoney = prizeMoney;
    }

    public static WinningRank of(int diffSize, boolean hasBonusNumber) {
        if (diffSize == 0) {
            return FIRST;
        }
        if (diffSize == 1 && hasBonusNumber) {
            return SECOND;
        }
        if (diffSize == 1) {
            return THIRD;
        }
        if (diffSize == 2) {
            return FOURTH;
        }
        if (diffSize == 3) {
            return FIFTH;
        }

        return NONE;
    }

    @Override
    public String toString() {
        return this.criteria + "개 일치 (" + this.prizeMoney + "원)";
    }
}
