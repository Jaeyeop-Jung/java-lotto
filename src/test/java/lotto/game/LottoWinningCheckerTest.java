package lotto.game;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constant.LottoWinningRanking;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.generator.LottoGenerator;
import lotto.generator.WinningLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningCheckerTest {

    @Test
    @DisplayName("로또가 당첨되지 않았을 경우를 테스트")
    void noWinning() {
        // given
        Lotto purchsedLotto = LottoGenerator.generateByNumbers("1,2,3,4,5,6");
        Lotto lottoWithWinningNumbers = LottoGenerator.generateByNumbers("7,8,9,10,11,12");
        WinningLotto winningLotto = WinningLottoGenerator.generate(lottoWithWinningNumbers, 13);
        LottoWinningChecker lottoWinningChecker = new LottoWinningChecker(winningLotto);

        // when
        LottoWinningRanking lottoWinningRanking = lottoWinningChecker.checkWinning(purchsedLotto);

        // then
        assertThat(lottoWinningRanking).isEqualTo(LottoWinningRanking.NOTHING);
    }

    @Test
    @DisplayName("로또가 4등에 당첨되었을 때를 테스트")
    void whenLottoWinsForth() {
        // given
        Lotto purchsedLotto = LottoGenerator.generateByNumbers("1,2,3,4,5,6");
        Lotto lottoWithWinningNumbers = LottoGenerator.generateByNumbers("1,2,3,4,7,8");
        WinningLotto winningLotto = WinningLottoGenerator.generate(lottoWithWinningNumbers, 9);
        LottoWinningChecker lottoWinningChecker = new LottoWinningChecker(winningLotto);

        // when
        LottoWinningRanking lottoWinningRanking = lottoWinningChecker.checkWinning(purchsedLotto);

        // then
        assertThat(lottoWinningRanking).isEqualTo(LottoWinningRanking.FOURTH);
    }

    @Test
    @DisplayName("로또가 3등에 당첨되었을 때를 테스트")
    void whenLottoWinsThird() {
        // given
        Lotto purchsedLotto = LottoGenerator.generateByNumbers("1,2,3,4,5,6");
        Lotto lottoWithWinningNumbers = LottoGenerator.generateByNumbers("1,2,3,4,5,7");
        WinningLotto winningLotto = WinningLottoGenerator.generate(lottoWithWinningNumbers, 8);
        LottoWinningChecker lottoWinningChecker = new LottoWinningChecker(winningLotto);

        // when
        LottoWinningRanking lottoWinningRanking = lottoWinningChecker.checkWinning(purchsedLotto);

        // then
        assertThat(lottoWinningRanking).isEqualTo(LottoWinningRanking.THIRD);
    }

    @Test
    @DisplayName("로또가 2등에 당첨되었을 때를 테스트")
    void whenLottoWinsSecond() {
        // given
        Lotto purchsedLotto = LottoGenerator.generateByNumbers("1,2,3,4,5,6");
        Lotto lottoWithWinningNumbers = LottoGenerator.generateByNumbers("1,2,3,4,5,7");
        WinningLotto winningLotto = WinningLottoGenerator.generate(lottoWithWinningNumbers, 6);
        LottoWinningChecker lottoWinningChecker = new LottoWinningChecker(winningLotto);

        // when
        LottoWinningRanking lottoWinningRanking = lottoWinningChecker.checkWinning(purchsedLotto);

        // then
        assertThat(lottoWinningRanking).isEqualTo(LottoWinningRanking.SECOND);
    }

    @Test
    @DisplayName("로또가 1등에 당첨되었을 때를 테스트")
    void whenLottoWinsFirst() {
        // given
        Lotto purchsedLotto = LottoGenerator.generateByNumbers("1,2,3,4,5,6");
        Lotto lottoWithWinningNumbers = LottoGenerator.generateByNumbers("1,2,3,4,5,6");
        WinningLotto winningLotto = WinningLottoGenerator.generate(lottoWithWinningNumbers, 7);
        LottoWinningChecker lottoWinningChecker = new LottoWinningChecker(winningLotto);

        // when
        LottoWinningRanking lottoWinningRanking = lottoWinningChecker.checkWinning(purchsedLotto);

        // then
        assertThat(lottoWinningRanking).isEqualTo(LottoWinningRanking.FIRST);
    }

}