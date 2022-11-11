package lotto.validator;

import static lotto.constant.Constants.UNIT_OF_LOTTO_PURCHASE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoPurchaseValidatorTest {

    @Nested
    @DisplayName("입력한 구입 금액이")
    class If_input_value_to_purchase {


        /**
         * 만약 구매 단위가 1원이라면 나머지가 생길 수 없기 때문에 테스트가 항상 통과한다
         */
        @Test
        @DisplayName("규칙에 맞지 않다면 예외를 던진다")
        void does_not_comply_with_rule_then_throw_exception() {
            if (UNIT_OF_LOTTO_PURCHASE == 1) {
                return;
            }

            // given
            int inputMoney = UNIT_OF_LOTTO_PURCHASE - 1;

            // when, then
            assertThatThrownBy(() -> LottoPurchaseValidator.validatePurchaseUnit(inputMoney))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.UNIT_OF_LOTTO_PURCHASE_DOES_NOT_COMPLY_WITH_RULE.message());
        }

        /**
         * 만약 구매 단위가 1원이라면 나머지가 생길 수 없기 때문에 테스트가 항상 통과한다
         */
        @Test
        @DisplayName("규칙에 맞다면 예외를 던지지 않는다")
        void does_comply_with_rule_then_does_not_throw_exception() {
            if (UNIT_OF_LOTTO_PURCHASE == 1) {
                return;
            }

            // given
            int inputMoney = UNIT_OF_LOTTO_PURCHASE;

            // when, then
            assertThatCode(() -> LottoPurchaseValidator.validatePurchaseUnit(inputMoney))
                    .doesNotThrowAnyException();
        }
    }
}

