package com.practice.springProj.Service;

import com.practice.springProj.Service.Interfaces.MedianTwoArrService;
import org.springframework.stereotype.Service;
//number 4
@Service
public class MedianTwoArrServiceImpl implements MedianTwoArrService {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Idx = 0;
        int nums2Idx = 0;
        double output;
        int i;
        int[] newArr = new int[nums1.length + nums2.length];

        for(i = 0; i < nums1.length + nums2.length; i++){
            if(nums1Idx >= nums1.length){
                newArr[i] = nums2[nums2Idx];
                nums2Idx++;
            } else if(nums2Idx >= nums2.length){
                newArr[i] = nums1[nums1Idx];
                nums1Idx++;
            } else if(nums1[nums1Idx] < nums2[nums2Idx]){
                newArr[i] = nums1[nums1Idx];
                nums1Idx++;
            } else if (nums1[nums1Idx] > nums2[nums2Idx]) {
                newArr[i] = nums2[nums2Idx];
                nums2Idx++;
            } else {
                newArr[i] = nums1[nums1Idx];
                nums1Idx++;
                i++;
                newArr[i] = nums2[nums2Idx];
                nums2Idx++;
            }
        }

        if((nums1.length + nums2.length) % 2 != 0){
            output = newArr[(nums1.length + nums2.length) / 2];
        } else {
            output = (newArr[(nums1.length + nums2.length) / 2]
                    + newArr[(nums1.length + nums2.length) / 2 - 1]) / 2.0;
        }

        return output;
    }
}
