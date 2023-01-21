package com.practice.springProj.Service;

import com.practice.springProj.Service.Interfaces.RegexMatchService;
import org.springframework.stereotype.Service;
//number 10
@Service
public class RegexMatchServiceImpl implements RegexMatchService {
    public boolean isMatch(String s, String p) {
        if (s == null) {
            return p == null;
        }
        if (s.equals("")) {
            return p.equals("");
        }

        int pIdx = 0;
        int sIdx = 0;
        while (sIdx < s.length()) {
            if (pIdx >= p.length()) return false;
            if (checkForStar(p, pIdx)) {
                if (p.charAt(pIdx) == '.') {
                    return handleDotStar(p, pIdx + 1, s, sIdx);
                } else {
                    return handleCharStar(p, pIdx + 1, s, sIdx);
                }
            } else {
                if (p.charAt(pIdx) == '.') {
                    pIdx++;
                } else {
                    if (p.charAt(pIdx) == s.charAt(sIdx)) pIdx++;
                    else return false;
                }
                sIdx++;
            }
        }

        if(pIdx < p.length()){
            return checkRemainingPattern(p, pIdx);
        }

        return true;
    }

    public boolean checkRemainingPattern(String p, int pIdx){
        while(pIdx < p.length()){
            if(!checkForStar(p, pIdx)) return false;
            pIdx+=2;
        }
        return true;
    }

    public boolean handleCharStar(String p, int idxOfStar, String s, int sIdx) {
        int holdIdx = sIdx;
        char repeatChar = p.charAt(idxOfStar - 1);
        while(holdIdx < s.length()) {
            if (isMatch(s.substring(holdIdx), p.substring(idxOfStar + 1)))
                return true;
            else if (s.charAt(holdIdx) == repeatChar) {
                holdIdx++;
                if (isMatch(s.substring(holdIdx), p.substring(idxOfStar + 1))) return true;
            } else {
                return false;
            }
        }

        return false;
    }

    public boolean handleDotStar(String p, int idxOfStar, String s, int sIdx) {
        if (idxOfStar == p.length() - 1) return true;

        int holdIdx = sIdx;
        while (holdIdx < s.length()) {
            if (isMatch(s.substring(holdIdx), p.substring(idxOfStar + 1)))
                return true;
            holdIdx++;
        }

        return false;
    }

    public boolean checkForStar(String p, int idxToCheck) {
        return idxToCheck + 1 < p.length()
                && p.charAt(idxToCheck + 1) == '*';
    }
}
