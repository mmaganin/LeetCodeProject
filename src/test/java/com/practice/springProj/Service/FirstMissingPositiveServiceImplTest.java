package com.practice.springProj.Service;

import com.practice.springProj.Service.Interfaces.FirstMissingPositiveService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FirstMissingPositiveServiceImplTest {

    FirstMissingPositiveService firstMissingPositiveService;
    @BeforeEach
    void setUp() {
        firstMissingPositiveService = new FirstMissingPositiveServiceImpl();
    }

//    @AfterEach
//    void tearDown() {
//    }

    private static Stream<Arguments> provideNumsArrParams() {
        return Stream.of(
                Arguments.of(new int[]{1,2,0}, 3),
                Arguments.of(new int[]{3,4,-1,1}, 2),
                Arguments.of(new int[]{7,8,9,11,12}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNumsArrParams")
    void firstMissingPositive(int[] nums, int expected) {
        int actual = firstMissingPositiveService.firstMissingPositive(nums);
        assertEquals(expected, actual);
    }
}