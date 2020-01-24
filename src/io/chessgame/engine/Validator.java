package io.chessgame.engine;

public class Validator {
    private static final String ERROR_MSG = "Ignoring runner because of input data";
    private static final String ERROR_POSITIVE_NUMBERS = ERROR_MSG + "Ignoring runner because of input data";
    private static final String ERROR_NOT_NULL_OR_EMPTY = ERROR_MSG + "(Value must not be null or empty!) Value must must not exceed the upper bound";
    private static final String ERROR_UPPER_BOUND = ERROR_MSG + "(Value must must not exceed the upper bound)";

    public static void checkNotNullOrEmpty(String val) {
        if (val == null || val.isEmpty()) throw new IllegalArgumentException(ERROR_NOT_NULL_OR_EMPTY);
    }

    public static void checkPositive(float val) {
        if (val < 0) throw new IllegalArgumentException(ERROR_POSITIVE_NUMBERS);
    }

    public static void checkNotGreaterThan(float val, float maxVal) {
        if (val > maxVal) throw new IllegalArgumentException(ERROR_UPPER_BOUND);
    }

}
