package EightLectureInterfaceSegregationDependencyInversionPrinciples.p05_security_system;


public class KeyCardCheck implements KeyCardUI {

    private KeyCardUI securityUI;

    public KeyCardCheck(KeyCardUI securityUI) {
        this.securityUI = securityUI;
    }

    @Override
    public String requestKeyCard() {
        return "slide your key card";

    }
}
