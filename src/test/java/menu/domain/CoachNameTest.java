package menu.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CoachNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"구", "구구구구구"})
    void validOutOfRangeName(String invalidName) {
        assertThrows(IllegalArgumentException.class, () -> new CoachName(invalidName));
    }
}