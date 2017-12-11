package FirstExersiceInterfaceAndAbstraction.MilitaryElite;

public class Mission implements IMission{
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        setState(state);
    }

    @Override
    public void completeMission(){
        this.state = "Finished";
    }

    public void setState(String state) {
        if (state.equals("inProgress") || state.equals("Finished")){
            this.state = state;

        }
        else{
            this.state = null;
        }
    }


    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s%n",this.codeName,this.state);
    }
}
