package LC;

public class BestTimetoClose {

        public int bestClosingTime(String customers) {
            //Lets create method to count penalty only, Count all Y present before the index and ALL Ns from the index

            //Find penalty and update minpenality in same loop

            int penalty = 0;

            // Initial penalty when store closes at hour 0
            // All Y are missed
            for (int i = 0; i < customers.length(); i++) {
                if (customers.charAt(i) == 'Y') {
                    penalty++;
                }
            }

            int minPenalty = penalty;
            int bestHour = 0;

            // Move closing time forward
            for (int i = 0; i < customers.length(); i++) {
                if (customers.charAt(i) == 'Y') {
                    penalty--;   // one less missed customer
                } else {
                    penalty++;   // stayed open with no customer
                }

                if (penalty < minPenalty) {
                    minPenalty = penalty;
                    bestHour = i + 1;
                }
            }

            return bestHour;

        }}