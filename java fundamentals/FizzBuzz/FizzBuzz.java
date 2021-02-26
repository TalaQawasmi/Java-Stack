public class FizzBuzz{
    public static void main(String [] args){
        System.out.println(FizzBuzz(10));
    }
    public static String FizzBuzz(int number){
        String value ="";
        if (number%3==0 && number%5==0){
            value = "FizzBuzz";
        }
        else if(number%3==0){
            value = "Fizz";
        }
        else if(number%5==0){
            value = "Buzz";
        }
        else{
            return Integer.toString(number);
        }
        return value;
    }
}