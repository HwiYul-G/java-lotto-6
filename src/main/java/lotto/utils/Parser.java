package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class Parser {

    public static int parseBudget(String budget) {
        try {
            return Integer.parseInt(budget);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                ExceptionMessage.INVALID_BUDGET_NON_NUMERIC.getMessage());
        }
    }

    public static Lotto parseToLotto(String input){
        List<Integer> numbers = Arrays.stream(input.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        return new Lotto(numbers);
    }


}
