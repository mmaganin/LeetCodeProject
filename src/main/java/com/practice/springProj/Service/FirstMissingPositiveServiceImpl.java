package com.practice.springProj.Service;

import com.practice.springProj.Service.Interfaces.FirstMissingPositiveService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

//number 41
@Service
public class FirstMissingPositiveServiceImpl implements FirstMissingPositiveService {
    @Override
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 1) {
            if(nums[0] == 1) return 2;
            return 1;
        }

        HashSet<Integer> positiveIntsSet = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        int smallestInt = nums[0];
        for(int i = 1; i <= nums.length; i++){
            if(!positiveIntsSet.contains(i)) return i;
            
        }

        return nums.length + 1;
    }
}
