package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public static final String SPACEBAR = " ";
    public static final String IS_NUMBER_REGEX = "[0-9]+";
    public static final String IS_OPERATOR_REGEX = "[-+*/]";
    public static final String IS_NULL_ERROR_MESSAGE = "입력 값이 null이거나 빈 공백 문자입니다.";
    public static final String IS_NOT_OPERATOR_ERROR_MESSAGE = "사칙연산 기호가 아닌 문자가 포함되어 있습니다.";

    public int execute(String input) {
        validateInput(input);
        String[] inputs = input.split(SPACEBAR);
        List<Integer> numbers = parsingNumber(inputs);
        List<String> operations = parsingOperation(inputs);
        return input(numbers, operations);
    }

    private void validateInput(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(IS_NULL_ERROR_MESSAGE);
        }
        if (isNotOperator(input)) {
            throw new IllegalArgumentException(IS_NOT_OPERATOR_ERROR_MESSAGE);
        }
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean isNotOperator(String input) {
        String[] inputs = input.split(SPACEBAR);

        return Arrays.stream(inputs)
                .anyMatch(s -> !s.matches(IS_NUMBER_REGEX) && !s.matches(IS_OPERATOR_REGEX));
    }

    private List<Integer> parsingNumber(String[] inputs) {
        List<Integer> numbers = new ArrayList<>();

        return Arrays.stream(inputs)
                .filter(input -> input.matches(IS_OPERATOR_REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<String> parsingOperation(String[] inputs) {
        List<String> operations = new ArrayList<>();

        return Arrays.stream(inputs)
                .filter(input -> input.matches(IS_OPERATOR_REGEX))
                .collect(Collectors.toList());
    }

    private int input(List<Integer> numbers, List<String> operations) {
        int result = numbers.get(0);

        for (int i = 0; i < operations.size(); i++) {
            result = calculate(result, numbers.get(i + 1), operations.get(i));
        }

        return result;
    }

    private int calculate(int oriNumber, int inputNumber, String operation) {
        return Operator.of(operation).calculate(oriNumber, inputNumber);
    }

}
