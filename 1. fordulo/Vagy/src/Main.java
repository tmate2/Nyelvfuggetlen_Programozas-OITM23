import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br;
        StringBuilder sb;

        for(int i = 1; i <= 5; i++){
            sb = new StringBuilder("input\\vagy").append(i).append(".in.txt");
            br = new BufferedReader(new FileReader(sb.toString()));

            String line = br.readLine();
            System.out.print(i+". "+"INPUT: "+line);

            BigInteger input = new BigInteger(line);
            BigInteger n = new BigInteger(new BigInteger("2").pow(input.bitLength()).toString());
            n = n.add(new BigInteger("-1"));

            System.out.println(", result: "+n);
            br.close();
        }
    }

}