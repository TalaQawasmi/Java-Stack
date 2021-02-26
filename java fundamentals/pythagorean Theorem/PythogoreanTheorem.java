import java.lang.Math;
public class PythogoreanTheorem {
    public static void main(String[] args){
        int legA=5;
        int legB=4;
        calculateHypotenuse(legA,legB);
    }
    public static double calculateHypotenuse(int legA, int legB) {
    double hypotenuse=Math.sqrt(Math.pow(legA,2)+ Math.pow(legB,2));
    System.out.println(hypotenuse);
    return hypotenuse;
    }
}