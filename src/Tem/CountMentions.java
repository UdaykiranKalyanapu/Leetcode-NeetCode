package Tem;

import java.util.List;

public class CountMentions {

        public int[] countMentions(int n, List<List<String>> events) {
            int[] mentions = new int[n];
            int[] back = new int[n];

            events.sort((a, b) -> {
                int ta = Integer.parseInt(a.get(1));
                int tb = Integer.parseInt(b.get(1));
                if (ta != tb) return ta - tb;
                return Boolean.compare(a.get(0).equals("MESSAGE"), b.get(0).equals("MESSAGE"));
            });

            for (List<String> event : events) {
                String type = event.get(0);
                int t = Integer.parseInt(event.get(1));
                String data = event.get(2);

                if (type.equals("OFFLINE")) {
                    int id = Integer.parseInt(data);
                    back[id] = t + 60;
                    continue;
                }

                String[] tokens = data.split(" ");
                for (String tok : tokens) {
                    if (tok.equals("ALL")) {
                        for (int u = 0; u < n; u++) {
                            mentions[u]++;
                        }
                    } else if (tok.equals("HERE")) {
                        for (int u = 0; u < n; u++) {
                            if (t >= back[u]) {
                                mentions[u]++;
                            }
                        }
                    } else {
                        int id = Integer.parseInt(tok.substring(2));
                        mentions[id]++;
                    }
                }
            }

            return mentions;
        }
    }
}
