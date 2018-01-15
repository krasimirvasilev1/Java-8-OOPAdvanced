package EightLectureInterfaceSegregationDependencyInversionPrinciples.p01_system_resources.entities;

import EightLectureInterfaceSegregationDependencyInversionPrinciples.p01_system_resources.interfaces.Writer;

public class WriterImpl  implements Writer{

    @Override
    public void println(String text) {
        System.out.println(text);
    }
}
