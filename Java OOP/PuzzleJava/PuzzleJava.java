import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class PuzzleJava{
    public static void main(){
        ArrayList<Integer> number= new ArrayList<Integer>();
        ArrayList<Integer> y= new ArrayList<Integer>();
        ArrayList<String> names= new ArrayList<String>();
        ArrayList<Character> alpha= new ArrayList<Character>();
        int value=10;
        numbers.add(3);
        numbers.add(5);
        numbers.add(1);
        numbers.add(2);
        numbers.add(7);
        numbers.add(9);
        numbers.add(8);
        numbers.add(13);
        numbers.add(25);
        numbers.add(32);
        System.out.println(numbers);
        Sum(numbers);
        names.add("Nancy");
        names.add("Jinichi");
        names.add("Fujibayashi");
        names.add("Momochi");
        names.add("Ishikawa");
        Collections.shuffle(names)
        Names(names);
        alpha.add(A);
        alpha.add(B);
        alpha.add(C);
        alpha.add(D);
        alpha.add(E);
        alpha.add(F);
        alpha.add(G);
        alpha.add(H);
        alpha.add(I);
        alpha.add(J);
        alpha.add(K);
        alpha.add(L);
        alpha.add(M);
        alpha.add(N);
        alpha.add(O);
        alpha.add(P);
        alpha.add(Q);
        alpha.add(R);
        alpha.add(S);
        alpha.add(T);
        alpha.add(U);
        alpha.add(V);
        alpha.add(W);
        alpha.add(X);
        alpha.add(Y);
        alpha.add(Z);
        Collections.shuffle(alpha);
        Alphabet(alpha);
        Random r = new Random();
        Rand(r);

    }
   
    public static void Sum(numbers,value,y){
        int sum = 0;
        
        for (int i=0; i<numbers.size;i++){
            sum += numbers.get(i);
            if (numbers.get(i)> 10){
                y.add(numbers.get(i));
            }
            System.out.println(sum);
            System.out.println(y);
        }
    }
    public static void Names(names){
        for (int i=0; i<names.size;i++){
            System.out.println(names);
            if (name.length(name.get(i))>5){
                System.out.println(name.get(i));
            }  
        }
    }
    public static void Alphabet(alpha){
        System.out.println(alpha.get(alpha.size-1));
        if(alpha.get(0)==a || alpha.get(0)==o || alpha.get(0)==e || alpha.get(0)==u){
            System.out.println("it is a vowel"):
        }
        else{
            System.out.println(alpha.get(0));
        }
    }
    public static int Rand(r){
        for (int i=55; i<r.size; i++){
            System.out.println(r.nextInt());
            return r.nextInt;
        }

    }
    public static void 
}