import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    /*** Akár 20+ percig is futhat az 5. feladat... ***/

    public static void main(String[] args) throws IOException {

        StringBuilder sb;
        BufferedReader br;

        for( int i = 1; i <= 5; i++) {
            sb = new StringBuilder("input/adat").append(i).append(".in.txt");
            br = new BufferedReader(new FileReader(sb.toString()));

            Moricka m = new Moricka();
            long pm = 0;
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                if (line.equals("p")) {
                    pm += Long.parseLong(m.pop_middle());
                    continue;
                }
                m.push_back(line);
            }
            br.close();

            System.out.println(i + ". result: " + pm);
        }
    }

}