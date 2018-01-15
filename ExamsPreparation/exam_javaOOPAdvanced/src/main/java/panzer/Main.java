package panzer;

import panzer.contracts.Manager;
import panzer.engine.GameEngine;
import panzer.handlers.CommandHandlerImpl;
import panzer.io.ConsoleReader;
import panzer.manager.ManagerVechiclesImpl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchFieldException {
        Manager manager = new ManagerVechiclesImpl();
        GameEngine gameEngine = new GameEngine(new ConsoleReader(),new CommandHandlerImpl(manager));

        gameEngine.run();
    }
}
