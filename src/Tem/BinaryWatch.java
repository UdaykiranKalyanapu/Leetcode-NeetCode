package Tem;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

        public List<String> readBinaryWatch(int turnedOn) {
            List<String> res = new ArrayList<>();
            for(int hour=0; hour<12; hour++){
                for(int min=0; min<60; min++){
                    int totalBit = Integer.bitCount(hour)+Integer.bitCount(min);
                    if(totalBit == turnedOn){
                        res.add(hour + ":" + String.format("%02d",min));
                    }
                }
            }
            return res;
        }
    }