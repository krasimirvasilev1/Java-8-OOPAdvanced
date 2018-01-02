package FifthExersiceReflection.pr0304BarracksMine.core.factories;

import FifthExersiceReflection.pr0304BarracksMine.contracts.Unit;
import FifthExersiceReflection.pr0304BarracksMine.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"FifthExersiceReflection.pr0304BarracksMine.models.units.";

	@SuppressWarnings("unchecked")
	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class newClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
		Constructor constructor = newClass.getDeclaredConstructor();
		constructor.setAccessible(true);
		return (Unit) constructor.newInstance();
	}
}
