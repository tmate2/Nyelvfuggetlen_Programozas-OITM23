import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Main {

    /* Program futása eltarthat egy ideig
     * eredmények
     * 26
     * 145
     * 916
     * 4325
     * 143745
     */

    public static void main(String[] args) throws IOException {

        /* Első sor: "N K"
         * - N: gyorshajtók száma
         * - K: mérési intervallum mp-ben
         * Következő N sor: "ora perc mp"
         */

        BufferedReader br;
        StringBuilder sb;

        for(int r = 1; r <= 5; r++) {

            sb = new StringBuilder("input/traffipax").append(r).append(".in.txt");
            br = new BufferedReader(new FileReader(sb.toString()));

            String[] tmp = br.readLine().split(" ");
            int N = Integer.parseInt(tmp[0]);
            int K = Integer.parseInt(tmp[1]);

            HashMap<MyTime, Integer> gyorsak = new HashMap<>();

            for (int i = 0; i < N; i++) {
                tmp = br.readLine().split(" ");
                MyTime tmp_time = new MyTime(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));
                if (gyorsak.containsKey(tmp_time)) {
                    gyorsak.put(tmp_time, gyorsak.get(tmp_time) + 1);
                    continue;
                }
                gyorsak.put(tmp_time, 1);
            }

            br.close();


            int max = 0;
            int n = 0;

            for (Entry<MyTime, Integer> entry : gyorsak.entrySet()) {
                MyTime key = entry.getKey().addTime(MyTime.timeFromSec(K));
                int counter = 0;
                for (Map.Entry<MyTime, Integer> entry2 : gyorsak.entrySet()) {
                    MyTime key2 = entry2.getKey();
                    int value2 = entry2.getValue();
                    if (key.minusTime(key2).timeToSec() <= K)
                        counter += value2;

                }
                if (counter > max) max = counter;
                n++;

                // Feldolgozás állapotáról visszajelzés
                if (n % 10000 == 0)
                    System.out.println("\t"+n + "/" + gyorsak.size() + " ( " + (((double) n / gyorsak.size()) * 100) + " % )");
            }

            System.out.println(r+". result: "+max);
        }

    }

}
