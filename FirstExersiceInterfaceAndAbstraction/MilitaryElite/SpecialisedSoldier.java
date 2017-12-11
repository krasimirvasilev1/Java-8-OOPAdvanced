package FirstExersiceInterfaceAndAbstraction.MilitaryElite;

public abstract class SpecialisedSoldier extends Private implements ISpecialisedSoldier {

    private String corps;

    protected SpecialisedSoldier(String id, String firstName, String lastName, double salary,String corps) {
        super(id, firstName, lastName, salary);
        setCorps(corps);
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    private void setCorps(String corps) {
        if (!corps.equals("Airforces") && !corps.equals("Marines")){
            throw new IllegalArgumentException();
        }
        else {
            this.corps = corps;
        }
    }
}
