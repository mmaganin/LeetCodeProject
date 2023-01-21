package com.practice.springProj.Service;

import com.practice.springProj.Service.Interfaces.TrapRainWaterService;
import org.springframework.stereotype.Service;

//number 42
@Service
public class TrapRainWaterServiceImpl implements TrapRainWaterService {
    @Override
    public int trap(int[] height) {
        if (height.length <= 2) return 0;

        HoleInfo currHoleInfo;
        int i;
        int totalCapacitySum = 0;
        int currCapacitySum;
        boolean couldHoldMoreWater = true;

        while (couldHoldMoreWater) {
            i = 0;
            currCapacitySum = 0;
            while (i < height.length) {
                currHoleInfo = getHoleInfoAtIdx(height, i);
                currCapacitySum += currHoleInfo.capacity;

                i = currHoleInfo.newIdxForPotentialHoles;
            }

            if(currCapacitySum == 0) couldHoldMoreWater = false;
            else totalCapacitySum += currCapacitySum;
        }

        return totalCapacitySum;
    }

    public HoleInfo getHoleInfoAtIdx(int[] height, int heightIdx) {
        boolean canHoldMoreWater = true;
        HoleInfo holeInfo = new HoleInfo();
        int leftIdx;
        int rightIdx;

        holeInfo.capacity = 0;
        holeInfo.newIdxForPotentialHoles = heightIdx + 1;

        if (heightIdx == 0 || heightIdx == height.length - 1) {
            return holeInfo;
        } else if (height[heightIdx - 1] < height[heightIdx] || height[heightIdx + 1] < height[heightIdx]) {
            return holeInfo;
        }

        leftIdx = heightIdx - 1;
        rightIdx = heightIdx + 1;
        while (canHoldMoreWater) {
            canHoldMoreWater = false;
            if (leftIdx - 1 >= 0 && height[leftIdx] <= height[leftIdx - 1]) {
                canHoldMoreWater = true;
                leftIdx = leftIdx - 1;
            }
            if (rightIdx + 1 < height.length && height[rightIdx] <= height[rightIdx + 1]) {
                canHoldMoreWater = true;
                rightIdx = rightIdx + 1;
            }
        }

        holeInfo.capacity = getCurrHoleCapacityAndFillHole(height, leftIdx, rightIdx);
        holeInfo.newIdxForPotentialHoles = rightIdx;

        return holeInfo;
    }

    public int getCurrHoleCapacityAndFillHole(int[] height, int leftIdx, int rightIdx) {
        int maxHeight = Math.min(height[leftIdx], height[rightIdx]);
        int capacitySum = 0;
        int capacityAtIdx;
        for (int i = leftIdx; i <= rightIdx; i++) {
            capacityAtIdx = maxHeight - height[i];
            if (capacityAtIdx > 0) {
                capacitySum += capacityAtIdx;
                height[i] = maxHeight;
            }
        }
        return capacitySum;
    }
}

class HoleInfo {
    int newIdxForPotentialHoles;
    int capacity;
}