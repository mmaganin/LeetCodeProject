package com.practice.springProj.Service;

import com.practice.springProj.Service.Interfaces.ReverseNodesService;
import com.practice.springProj.Utility.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReverseNodesServiceImplTest {
    ReverseNodesService reverseNodesService;

    @BeforeEach
    void setUp() {
        reverseNodesService = new ReverseNodesServiceImpl();
    }

    private static Stream<Arguments> provideParamsForReverseKGroup() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,5}, 2, new int[]{2,1,4,3,5}),
                Arguments.of(new int[]{1,2,3,4,5}, 3, new int[]{3,2,1,4,5})
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForReverseKGroup")
    void testReverseKGroup_AllCases(int[] inputArr, int kInput, int[] expectedOutput) {
        ListNode listNode = new ListNode();
        int[] actualOutput = listNode.listNodeToIntArr(reverseNodesService.reverseKGroup(listNode.intArrToListNode(inputArr), kInput));
        assertArrayEquals(expectedOutput, actualOutput);
    }
}