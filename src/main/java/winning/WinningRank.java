package winning;

public enum WinningRank {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
    NONE;

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
}
