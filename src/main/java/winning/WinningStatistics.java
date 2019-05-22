package winning;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningStatistics {

    private Map<WinningRank, Integer> resultMap;

    public WinningStatistics(List<WinningRank> winningRanks) {
        this.resultMap = winningRanks.stream().collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
    }

    private String makeRankString(WinningRank rank) {
        return rank + " - " + resultMap.getOrDefault(rank, 0) + "개";
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator()
                , "당첨 통계"
                , "---------"
                , makeRankString(WinningRank.FIFTH)
                , makeRankString(WinningRank.FOURTH)
                , makeRankString(WinningRank.THIRD)
                , makeRankString(WinningRank.SECOND)
                , makeRankString(WinningRank.FIRST));
    }
}
