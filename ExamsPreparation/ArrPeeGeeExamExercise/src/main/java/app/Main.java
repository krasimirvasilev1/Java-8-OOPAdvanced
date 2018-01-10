package app;

import app.contracts.*;
import app.controller.BattlefieldImpl;
import app.factory.ActionFactoryImpl;
import app.factory.TargetableFactoryImpl;
import app.handlers.CommandHandlerImpl;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        ActionFactory actionFactory = new ActionFactoryImpl();
        TargetableFactory targetableFactory = new TargetableFactoryImpl();

        Battlefield battleField = new BattlefieldImpl(actionFactory, targetableFactory, writer);
        CommandHandler handler = new CommandHandlerImpl(battleField);

        Engine engine = new GameEngine(reader, handler);
        engine.run();

    }
}
