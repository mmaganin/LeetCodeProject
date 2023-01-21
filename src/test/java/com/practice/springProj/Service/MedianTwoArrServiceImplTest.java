package com.practice.springProj.Service;

import com.practice.springProj.Service.Interfaces.MedianTwoArrService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MedianTwoArrServiceImplTest {

    MedianTwoArrService medianTwoArrService;

    @BeforeEach
    void setUp() {
        medianTwoArrService = new MedianTwoArrServiceImpl();
    }

    private static Stream<Arguments> provideIntArrs() {
        return Stream.of(
                Arguments.of(new int[]{1,3}, new int[]{2}, 2.0),
                Arguments.of(new int[]{1,2}, new int[]{3,4}, 2.5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideIntArrs")
    void testFindMedianSortedArrays(int[] inputArr1, int[] inputArr2, double expected) {
        double actual = medianTwoArrService.findMedianSortedArrays(inputArr1, inputArr2);
        assertEquals(expected, actual);
    }
}