import java.util.ArrayList;
public class Portfolio{
    private ArrayList<Project> ListP = new ArrayList<Project>();
    public Portfolio(){
    }
    public ArrayList<Project> getListP(){
        retrun this.ListP;
    }
    public void setListP(Project newP){
        this.ListP.add(newP);
    }
    public double getPortfolioCost(){
        double sum =0.0;
        for (int i=0; i<ListP.size; i++){
            sum += this.ListP.get(i).getInitialCost();
        }
        return sum;
    }
    public void showPortfolio(){
        for(int i=0; i<ListP.size(); i++){
            System.out.println(this.ListP.get(i).elevatorPitch());
        }
        System.out.println(this.getPortfolioCost());
    }
}