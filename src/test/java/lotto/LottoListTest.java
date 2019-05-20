package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoListTest {

    private static final String LOTTO_STR_REGEX = "\\[([0-9]+, ){5}([0-9]+{1})\\]"; // [1, 2, 3, 4, 5, 6] 형태

    @Test
    public void 구입한_개수만큼_로또_번호를_받는다() {
        LottoList lottoList = new LottoList(3);

        assertThat(lottoList.size()).isEqualTo(3);

        assertThat(lottoList.lottoString(0)).isNotBlank().
            asString().containsPattern(LOTTO_STR_REGEX);
        assertThat(lottoList.lottoString(1)).isNotBlank().
                asString().containsPattern(LOTTO_STR_REGEX);
        assertThat(lottoList.lottoString(2)).isNotBlank().
                asString().containsPattern(LOTTO_STR_REGEX);
    }
}
