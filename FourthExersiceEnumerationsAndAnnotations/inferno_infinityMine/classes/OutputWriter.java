package FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.classes;

import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.interfaces.Writer;

public class OutputWriter implements Writer {
    public OutputWriter() {
    }

    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
