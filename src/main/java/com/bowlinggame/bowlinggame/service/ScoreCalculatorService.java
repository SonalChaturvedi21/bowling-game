package com.bowlinggame.bowlinggame.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.bowlinggame.bowlinggame.model.Set;

/*
 * Score calculator class to calculate the score of 10 sets(20 rolls)
 * with bonuses for strikes(+10) and spares(+5)
 * */

@Service
public class ScoreCalculatorService {

	public final int MaxNumber = 10;
    public List<Set> sets;
    public int result = 0;
    
    public ScoreCalculatorService(List<Set> sets){
        this.sets = sets;
    }
    
    public int score() {
        if(sets != null){
            for(int i=0;i < MaxNumber ; i++){
                if(sets.get(i).isStrike()){
                    result +=  sets.get(i).numberOfKnockedPins() + bonusStrike(i);
                }
                else if(sets.get(i).isSpare()){
                    result += sets.get(i).numberOfKnockedPins() + bonusSpare(i);
                }
                else {
                    result += sets.get(i).numberOfKnockedPins();
                }
            }
            return result;
        }
        else
                return 0;
    }

    private int bonusSpare(int i) {
        return 5;
    }

    private int bonusStrike(int i) {
        return 10;
    }
}
