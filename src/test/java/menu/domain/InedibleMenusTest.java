package menu.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InedibleMenusTest {
    @ParameterizedTest
    @CsvSource(value = {"김치찌개,비빔밥:2", "비빔밥:1", "비빔밥   :1"}, delimiter = ':')
    void createInedibleMenus(String input, int expectedSize) {
        InedibleMenus inedibleMenus = new InedibleMenus(input);
        assertEquals(expectedSize, inedibleMenus.getMenus().size());
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void createWithEmptyString(String input) {
        InedibleMenus inedibleMenus = new InedibleMenus(input);
        assertEquals(0, inedibleMenus.getMenus().size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"김치찌개,비빔밥,우동"})
    void validOutOfRangeMenus(String invalidMenus) {
        assertThrows(IllegalArgumentException.class, () -> new InedibleMenus(invalidMenus));
    }
}