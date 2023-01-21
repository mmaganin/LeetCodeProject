package com.practice.springProj.Service;

import com.practice.springProj.Service.Interfaces.SudokuService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SudokuServiceImpl implements SudokuService {
    HashMap<Integer, Set<Character>> possibleNumsRows = new HashMap<>();
    HashMap<Integer, Set<Character>> possibleNumsCols = new HashMap<>();
    HashMap<Integer, Set<Character>> possibleNumsSects = new HashMap<>();
    @Override
    public void solveSudoku(char[][] board) {


    }

    public void populatePossibleNumsRows(char[][] board){
        HashSet<Integer> numsInRow = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
//                board[i][j]
            }
        }
    }


}

class BoardCoords{
    int x;
    int y;
}
