package EightLectureInterfaceSegregationDependencyInversionPrinciples.p05_security_system;

import java.util.Scanner;

public class ScannerUI implements PinCodeUI,KeyCardUI {
    private Scanner scanner;

    public ScannerUI(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String requestKeyCard() {
        return null;
    }

    @Override
    public int requestPinCode() {
        return 0;
    }
}
