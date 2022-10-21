public class testOne {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int et = 0, ext = 0;
        
        for(int e : energy){
            initialEnergy -= e;
            while(initialEnergy <= 0){
                et++;
                initialEnergy++;
            }
        }
        
        for(int ex : experience){
            while(initialExperience <= ex){
                ext++;
                initialExperience++;
            }
            initialExperience += ex;
        }
        
        return et + ext;
    }
}
