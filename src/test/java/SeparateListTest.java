import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SeparateListTest {
    @ParameterizedTest
    @MethodSource("inputProvider")
    void separate(List<Integer> list, int k, boolean expected) {
        boolean result = SeparateList.separate(list, k);
        assertEquals(expected, result);

    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 3, false),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 2), 2, true),
                Arguments.of(Arrays.asList(1, 2, 3, 2, -1, 2), 3, true),
                Arguments.of(Arrays.asList(-2, -4, -3, -3), 2, true),
                Arguments.of(Arrays.asList(1), 0, false),
                Arguments.of(Arrays.asList(1), 0, false),
                Arguments.of(Arrays.asList(1, 2), 1, true),
                Arguments.of(Arrays.asList(), 1, false),
                Arguments.of(Arrays.asList(11), 1, true));
    }

}