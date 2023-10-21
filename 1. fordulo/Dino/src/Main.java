import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        StringBuilder sb;
        BufferedReader br;

        for( int i = 1; i <= 5; i++){
            sb = new StringBuilder("input\\dino").append(i).append(".in.txt");
            br = new BufferedReader(new FileReader(sb.toString()));

            ArrayList<Dino> dinok = new ArrayList<>();

            for(String line = br.readLine(); line != null; line = br.readLine()){
                String[] tmp = line.split(" ");
                dinok.add(new Dino(Double.parseDouble(tmp[0]), Double.parseDouble(tmp[1])));
            }

            dinok.sort((o1, o2) -> {
                int s = Double.compare(o1.tomeg, o2.tomeg) * -1;
                if (s != 0) return s;
                return Double.compare(o1.hossz, o2.hossz) * -1;
            });

            ArrayList<Dino> nem_eheto = new ArrayList<>();
            nem_eheto.add(dinok.get(0));

            int index = 1;
            while (index < dinok.size()){

                for( int j = 0; j < nem_eheto.size(); j++){

                    if( nem_eheto.get(j).megeszi(dinok.get(index))){
                        index++;
                        break;
                    }
                    if( !nem_eheto.get(j).megeszi(dinok.get(index)) && j == nem_eheto.size()-1){
                        nem_eheto.add(dinok.get(index));
                        index++;
                        j++;
                    }
                }
            }
            System.out.println(i+". result: "+ nem_eheto.size());

        }

    }

}