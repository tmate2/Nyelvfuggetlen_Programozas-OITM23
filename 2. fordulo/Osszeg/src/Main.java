import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br;
        StringBuilder sb;

        for(int r = 1; r <= 5; r++) {
            sb = new StringBuilder("input/osszeg").append(r).append(".in.txt");
            br = new BufferedReader(new FileReader(sb.toString()));

            ArrayList<Integer> al = new ArrayList<>();
            for (String x : br.readLine().split(" "))
                al.add(Integer.parseInt(x));
            br.close();

            for (int i = 0; i < al.size(); i++) {
                int tmp = 0;
                for (int j = i; j < al.size(); j++) {
                    if (tmp != 0 && tmp == al.get(j)) {
                        System.out.println(r + ". result: " + "i = " + i + ", j = " + (j - 1));
                        i = al.size();
                        break;
                    }
                    tmp += al.get(j);
                }
            }

        }
    }

}