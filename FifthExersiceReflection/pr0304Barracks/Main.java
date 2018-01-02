package FifthExersiceReflection.pr0304Barracks;

import FifthExersiceReflection.pr0304Barracks.contracts.CommandInterpreter;
import FifthExersiceReflection.pr0304Barracks.contracts.Repository;
import FifthExersiceReflection.pr0304Barracks.contracts.Runnable;
import FifthExersiceReflection.pr0304Barracks.contracts.UnitFactory;
import FifthExersiceReflection.pr0304Barracks.core.Engine;
import FifthExersiceReflection.pr0304Barracks.core.factories.UnitFactoryImpl;
import FifthExersiceReflection.pr0304Barracks.data.UnitRepository;
import FifthExersiceReflection.pr0304Barracks.interpreters.CommandInterpreterImpl;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		CommandInterpreter interpreter = new CommandInterpreterImpl();
		Runnable engine = new Engine(repository, unitFactory, interpreter);
		engine.run();
	}
}
