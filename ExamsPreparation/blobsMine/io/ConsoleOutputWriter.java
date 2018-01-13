package blobsMine.io;


import blobsMine.interfaces.OutputReader;

public class ConsoleOutputWriter implements OutputReader {
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) {
        System.out.println(String.format(format, params));
    }
}
