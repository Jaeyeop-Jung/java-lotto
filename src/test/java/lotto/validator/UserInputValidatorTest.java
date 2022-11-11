package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserInputValidatorTest {

    @Nested
    @DisplayName("사용자가 입력한 문자열이")
    class If_user_input_is {

        @Test
        @DisplayName("숫자가 아닐 경우 예외를 던진다")
        void not_numeric() {
            // given
            String input = "로또게임";

            // when, then
            assertThatThrownBy(() -> UserInputValidator.validateStringIsNumeric(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.MONEY_IS_ALLOWED_ONLY_NUMERIC.getMessage());
        }

        @Test
        @DisplayName("숫자일 경우 예외를 던지지 않는다")
        void numeric() {
            // given
            String input = "123";

            // when, then
            assertThatCode(() -> UserInputValidator.validateStringIsNumeric(input))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("사용자가 입력한 당첨 번호 문자열이")
    class If_user_winning_lotto_number_input_is {

        @Test
        @DisplayName("규칙에 맞지 않으면 예외를 던진다")
        void does_not_comply_with_rule() {
            // given
            String input = ",1,,1,";

            // when, then
            assertThatThrownBy(() -> UserInputValidator.validateWinningLottoNumberComplyWithRule(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(
                            ErrorMessage.USER_INPUT_DOES_NOT_COMPLY_WITH_RULE_FOR_WINNING_LOTTO_NUMBER.getMessage());
        }

        @Test
        @DisplayName("규칙에 맞다면 예외를 던지지 않는다")
        void does_comply_with_rule() {
            // given
            String input = "1,2,3,4,5,6";

            // when, then
            assertThatCode(() -> UserInputValidator.validateWinningLottoNumberComplyWithRule(input))
                    .doesNotThrowAnyException();
        }
    }
}