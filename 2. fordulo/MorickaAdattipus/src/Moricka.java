import java.util.ArrayList;


public class Moricka {

    private final ArrayList<String> al;

    public Moricka(){
        al = new ArrayList<>();
    }

    public void push_back(String x){
        al.add(x);
    }

    public String pop_middle() {
        if (al.isEmpty()) return "0";

        int index = (int)Math.floor((double)al.size()/2);
        String tmp = al.get(index);
        al.remove(index);
        return tmp;
    }

}
