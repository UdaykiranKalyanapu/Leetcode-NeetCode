package Tem;

public class BinaryEasy {

        public int binaryGap(int n) {
            int i=0;
            int cnt = 0;
            int idx = 0;
            int gap = 0;
            while(n!=0){
                if((n&1)==1){
                    if(cnt!=0){
                        gap = Math.max(gap, i-idx);
                    }
                    idx = i;
                    cnt++;
                }
                n=n>>1;
                i++;
            }

            return gap;
        }

    }