package com.practice.springProj.Service;

import com.practice.springProj.Service.Interfaces.RegexMatchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RegexMatchServiceImplTest {
    RegexMatchService regexMatchService;

    @BeforeEach
    void setUp() {
        regexMatchService = new RegexMatchServiceImpl();
    }

//    @AfterEach
//    void tearDown() {
//    }

    private static Stream<Arguments> provideStringsForTrueCases() {
        return Stream.of(
                Arguments.of("aa", "a*"),
                Arguments.of("ababababab", "abab.b.bab"),
                Arguments.of("mississippi", "mis*is*ip*."),
                Arguments.of("ab", ".*"),
                Arguments.of("abfgsahfgjsd", ".*"),
                Arguments.of("avvvvbbqxxxxqa", "a.*bqx.*a"),
                Arguments.of("ababababab", "ababababab"),
                Arguments.of("aaa", "a*a"),
                Arguments.of("aaa", "ab*a*c*a"),
                Arguments.of("a", "ab*")
                );
    }

    private static Stream<Arguments> provideStringsForFalseCases() {
        return Stream.of(
                Arguments.of("avbb", "a.*bc"),
                Arguments.of("aaaaab", "a*"),
                Arguments.of("avvvvbbqxxxxq", "a.*bqx.*a"),
                Arguments.of("ababababab", "abababa"),
                Arguments.of("ababababab", "ababababababababab"),
                Arguments.of("a", "ab*a"),
                Arguments.of("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c")
                );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForTrueCases")
    void testIsMatch_TrueCases(String expression, String pattern) {
        assertTrue(regexMatchService.isMatch(expression, pattern));
    }

    @ParameterizedTest
    @MethodSource("provideStringsForFalseCases")
    void testIsMatch_FalseCases(String expression, String pattern) {
        assertFalse(regexMatchService.isMatch(expression, pattern));
    }




//    @Test
//    void testGetNewSIdxForStar_() {
//        expression = "aa";
//        pattern = "a*";
//
//        assertEquals(2, regexMatchServiceImpl.getNewSIdxForStar(pattern, 1, expression, 0));
//    }
}