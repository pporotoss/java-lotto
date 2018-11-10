package game.lotto.model;

import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또_생성() {
        Lotto lotto = new Lotto();

        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    public void 일치하는_갯수() {
        final String stringNumbers = "1, 2, 3, 7, 8, 9";
        final Set<LottoNumber> lottoNumbers = LottoNumberFactory.createLottoNumbers(stringNumbers);
        final Lotto lotto = new Lotto(lottoNumbers);

        final String otherStringNumbers = "1, 2, 3, 4, 5, 6";
        final Set<LottoNumber> otherNumbers = LottoNumberFactory.createLottoNumbers(otherStringNumbers);

        int matchCount = lotto.match(otherNumbers);

        assertThat(matchCount).isEqualTo(3);
    }
}