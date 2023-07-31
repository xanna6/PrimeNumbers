package apiotrowska.primenumbers;

import apiotrowska.primenumbers.service.PrimeNumberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest
class PrimeNumbersApplicationTests {

    static Stream<Arguments> arrayListProvider() {

        List<Arguments> argList = new ArrayList<>();
        List<Integer> expectedResult;
        int testInput;

        // Test set 1
        testInput = 24;
        expectedResult = new ArrayList<>(Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23));
        argList.add(arguments(testInput, expectedResult));

        // Test set 2
        testInput = 40;
        expectedResult = new ArrayList<>(Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37));
        argList.add(arguments(testInput, expectedResult));

        //Test set 3
        testInput = 2;
        expectedResult = new ArrayList<>(Collections.singletonList(2));
        argList.add(arguments(testInput, expectedResult));

        //Test set 4
        testInput = 1;
        expectedResult = new ArrayList<>();
        argList.add(arguments(testInput, expectedResult));

        //Test set 5
        testInput = 0;
        expectedResult = new ArrayList<>();
        argList.add(arguments(testInput, expectedResult));

        return argList.stream();

    }

    @ParameterizedTest
    @MethodSource("arrayListProvider")
    void testFindPrimeNumbers(int input, ArrayList<Integer> expectedResult) {
        PrimeNumberService service = new PrimeNumberService();
        List<Integer> actual = service.findPrimeNumbersLessThan(input);
        assertThat(actual, is(expectedResult));
    }

    @Test
    void testFindPrimeNumbersWithNegativeBoundary() {
        PrimeNumberService service = new PrimeNumberService();
        Exception exception = assertThrows(NegativeArraySizeException.class, () -> service.findPrimeNumbersLessThan(-1));
    }

}
