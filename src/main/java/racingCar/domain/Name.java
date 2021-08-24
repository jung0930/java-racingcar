package racingCar.domain;

public class Name {

    private final String name;
    private static final int MIN_LENGTH_BY_NAME = 1;
    private static final int MAX_VALUE_BY_NAME = 5;
    private static final String IS_NULL_OR_EMPTY_ERROR_MESSAGE = "자동차의 이름을 입력해주세요.";
    private static final String IS_NOT_BETWEEN_ONE_AND_FIVE_ERROR_MESSAGE = "자동차의 이름은 1~5글자 사이로 입력해야 합니다.";

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    public void validateName(String name) {
        validateEmpty(name);
        validateNameLength(name);
    }

    private void validateEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(IS_NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }

    private void validateNameLength(String name) {
        if (name.trim().length() < MIN_LENGTH_BY_NAME || name.trim().length() > MAX_VALUE_BY_NAME) {
            throw new IllegalArgumentException(IS_NOT_BETWEEN_ONE_AND_FIVE_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return this.name;
    }

}
