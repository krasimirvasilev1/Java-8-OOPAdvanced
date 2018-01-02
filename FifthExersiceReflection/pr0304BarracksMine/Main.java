package FifthExersiceReflection.pr0304BarracksMine;

import FifthExersiceReflection.pr0304BarracksMine.contracts.CommandInterpreter;
import FifthExersiceReflection.pr0304BarracksMine.contracts.Repository;
import FifthExersiceReflection.pr0304BarracksMine.contracts.Runnable;
import FifthExersiceReflection.pr0304BarracksMine.contracts.UnitFactory;
import FifthExersiceReflection.pr0304BarracksMine.core.Engine;
import FifthExersiceReflection.pr0304BarracksMine.core.factories.UnitFactoryImpl;
import FifthExersiceReflection.pr0304BarracksMine.data.UnitRepository;
import FifthExersiceReflection.pr0304BarracksMine.interpretes.CommandInterpretesImpl;

import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		CommandInterpreter command = new CommandInterpretesImpl();
		Runnable engine = new Engine(repository, unitFactory,command);
		engine.run();
	}
}
