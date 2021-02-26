public class StringManipulator(){
    public static void main(String [] args){
        StringManipulatorTest manipulator = new.StringManipulatorTest();
        string str= manipulator.trimAndConcat("    Hello     ","     World    ");
        System.out.println(str);
    }
}