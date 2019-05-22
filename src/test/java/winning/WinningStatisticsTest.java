package winning;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {

    @Test
    public void 로또_당첨_통계를_확인할_수_있다() {
        WinningStatistics statistics = new WinningStatistics(Arrays.asList(WinningRank.FIFTH, WinningRank.FIRST));

        assertThat(statistics.toString()).isNotBlank().isEqualTo("당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원) - 1개\n" +
                "4개 일치 (50000원) - 0개\n" +
                "5개 일치 (1500000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치(30000000원) - 0개\n" +
                "6개 일치 (2000000000원) - 1개");
    }
}
