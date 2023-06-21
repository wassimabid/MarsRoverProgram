package com.bnp.rover.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlateauTest {
    @ParameterizedTest
    @CsvSource({
            "0, 0, true",
            "2, 3, true",
            "5, 5, true",
            "-1, 0, false",
            "0, -1, false",
            "6, 5, false",
            "2, 6, false"
    })
    void testIsValidPosition(int x, int y, boolean expected) {
        Plateau plateau = new Plateau(5, 5);
        boolean result = plateau.isValidPosition(x, y);
        Assertions.assertEquals(expected, result);
    }
}
