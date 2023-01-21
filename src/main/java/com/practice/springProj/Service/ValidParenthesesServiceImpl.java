package com.practice.springProj.Service;

import com.practice.springProj.Service.Interfaces.ValidParenthesesService;
import org.springframework.stereotype.Service;

import java.util.Stack;

//number 32
//havent passed on leetcode
@Service
public class ValidParenthesesServiceImpl implements ValidParenthesesService {

    //working n^2 solution didnt pass time limit cases
    @Override
    public int longestValidParentheses(String s) {
        Stack<Character> leftParenthesesStack = new Stack<>();
        int currNumValid;
        int maxNumValid = 0;
        int j;

        for (int i = 0; i < s.length(); i++) {
            currNumValid = 0;
            for (j = i; j < s.length(); j++) {
                if (leftParenthesesStack.isEmpty() && s.charAt(j) == ')') break;
                else if(s.charAt(j) == '(') leftParenthesesStack.push('(');
                else leftParenthesesStack.pop();

                if(leftParenthesesStack.isEmpty()) currNumValid = j - i + 1;
            }
            if(currNumValid > maxNumValid) {
                maxNumValid = currNumValid;
            }
            leftParenthesesStack.clear();
        }
        return maxNumValid;
    }
}
