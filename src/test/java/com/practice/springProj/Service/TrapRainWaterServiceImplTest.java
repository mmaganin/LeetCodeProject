package com.practice.springProj.Service;

import com.practice.springProj.Service.Interfaces.TrapRainWaterService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrapRainWaterServiceImplTest {
    TrapRainWaterService trapRainWaterService;
    @BeforeEach
    void setUp() {
        trapRainWaterService = new TrapRainWaterServiceImpl();
    }

//    @AfterEach
//    void tearDown() {
//    }

    private static Stream<Arguments> provideConcatSubstringTestParams() {
        return Stream.of(
                Arguments.of(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6),
                Arguments.of(new int[]{4,2,0,3,2,5}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("provideConcatSubstringTestParams")
    void testTrap(int[] input, int expected) {
        int actual = trapRainWaterService.trap(input);
        assertEquals(expected, actual);
    }
}