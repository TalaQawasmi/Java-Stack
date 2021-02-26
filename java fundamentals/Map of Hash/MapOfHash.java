import java.util.set;
public class MapOfHash{
    public static void main(String [] args){
        HashMap<String, String> usermap = new HashMap<String, String>();
        usermap.put("my hero","i could be your hero baby, i will stand by you forever");
        usermap.put("price tag","it aint about the money, we dont need your money, we just wana make the world dance");
        usermap.put("slim shady","will the real slim shady please stand up");
        usermap.put("7 rings","my wrist stop watchin, my neck is flossy");
        System.out.println(usermap.get("price tag"));
        Set<String> keys = usermap.keyset();
        for(String key : keys){
            System.out.println(key);
            System.out.println(usermap.get(key));
        } 
    }
}