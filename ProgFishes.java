import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ProgFishes extends Thread{
    ArrayList<String> arr = new ArrayList<>();
    public ProgFishes(ArrayList<String> fish) {
        this.arr = fish;

    }
    public static void main(String[] args) {
        
        ArrayList<String> list = new ArrayList<>(Arrays.asList("MF","MF","MF","MF","MF","MF","MF","MF","MF","MF","FF","FF","FF","FF","FF","FF","FF","FF","FF","FF"));
        for(int i=1;i<=5;i++)
        {
            ProgFishes thread1 = new ProgFishes(list);
            thread1.start();
        }
    }
    @Override
    public void run() {
        synchronized(arr)
        {
            int r1 = (int)(Math.random()*arr.size()-1)% arr.size();
            int r2 = (int)(Math.random()*arr.size()-1)% arr.size();
            String fish1 = arr.get(r1);
            String fish2 = arr.get(r2);
            if(fish1=="MF" && fish2=="MF")
            {
                arr.remove(r1);
                arr.remove(r2);                
            }
            if(fish1==fish2)
            {
                if(fish1=="FF")
                {
                    int random = new Random().nextBoolean() ? r1 : r2;
                    arr.remove(random);
                }
            }
            if(fish1=="MF" && fish2=="FF" || fish1=="FF" && fish2=="MF")
            {
                String child1 = new Random().nextBoolean() ? "MF" : "FF";
                String child2 = new Random().nextBoolean() ? "MF" : "FF";
                arr.add(child1);
                arr.add(child2);

            }
        }
        System.out.println(arr);
    }
}