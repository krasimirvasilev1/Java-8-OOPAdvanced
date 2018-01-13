package blobsMine.interfaces;

public interface OutputReader {

    void writeLine(String output);

    void writeLine(String format, Object... params);
}
