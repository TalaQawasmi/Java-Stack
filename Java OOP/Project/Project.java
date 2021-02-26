public class Project{
    Private String name="";
    Private String name="";
    Private double initialCost=0.0;
    public Project(){

    }
    public Project(String name, String desc, double initialCost){
        this.name = name;
        this.desc = desc;
        this.initialCost = initialCost;
    }
    public String getName(){
        return this.name;
    }
    public String getDesc(){
        return this.desc;
    }
    public String getInitialCost(){
        return this.initialCost;
    }
    public String setName(String name){
        this.name =name;
    }
    public String setDesc(String desc){
        this.desc = desc;
    }
    public double setInitialCost(double initialCost){
        this.initialCost = initialCost;
    }
    public String elevatorPitch(){
        return this.name + "(" + this.initialCost + ")" + ":" + this.desc;
    }
}