package FirstExersiceInterfaceAndAbstraction.MilitaryElite;

public abstract class Soldier implements ISoldier {
    private String id;
    private String firstName;
    private String lastName;

    protected Soldier(String id, String firstName, String lastName) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }
}
