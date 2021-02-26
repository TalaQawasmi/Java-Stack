public class Project1Test{
    public static void main (String [] args){
        Project first = new Project();
        Project second = new Project("ideal");
        Project third = new Project("ideal1","My company");
        Project forth = new Project("ideal3","my company", 500.00);
        Portfolio portfolio11 = new Portfolio();
        portfolio1.setProjectList(first);
        portfolio1.setProjectList(second);
        portfolio1.setProjectList(third);
        portfolio1.setProjectList(forth);
        System.out.println(portfolio1.getPortfolioCost());
        portfolio1.showPortfolio();
    }
}