public class exceptions{
    public static void main(String [] args){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for(int i = 0; i < myList.size(); i++){
            Integer castedValue = (Integer) myList.get(i);
        }
        try{
            myList.deliverMessage();
            System.out.println("This message was delivered  ")
        }
        catch (empty e){
            System.out.println("this is catch");
        }
    }
}