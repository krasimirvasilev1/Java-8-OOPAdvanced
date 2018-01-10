package hell.io;

import hell.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader implements InputReader {
    private BufferedReader console;

    public ConsoleInputReader() {
        this.console = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine(){
        String line = null;
        try {
            line = this.console.readLine();
        } catch (IOException ignored) {
        }
        return line;
    }
}
