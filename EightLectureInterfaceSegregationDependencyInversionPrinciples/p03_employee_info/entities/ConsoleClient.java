package EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.entities;

import EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.interfaces.Formatter;
import EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.interfaces.InfoProvider;

public class ConsoleClient {
    private Formatter formatter;
    private InfoProvider infoProvider;


    public ConsoleClient(Formatter formatter, InfoProvider infoProvider) {
        this.formatter = formatter;
        this.infoProvider = infoProvider;
    }

    public Formatter getFormatter() {
        return this.formatter;
    }

    public InfoProvider getInfoProvider() {
        return this.infoProvider;
    }
}
