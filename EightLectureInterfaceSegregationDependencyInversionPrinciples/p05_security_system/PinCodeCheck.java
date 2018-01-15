package EightLectureInterfaceSegregationDependencyInversionPrinciples.p05_security_system;

public class PinCodeCheck implements PinCodeUI {

    private PinCodeUI securityUI;

    public PinCodeCheck(PinCodeUI securityUI) {
        this.securityUI = securityUI;
    }

    @Override
    public int requestPinCode() {
        return 0;
    }
}
