package FifthExersiceReflection.pr0304Barracks.core.factories;

import FifthExersiceReflection.pr0304Barracks.contracts.Unit;
import FifthExersiceReflection.pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {
	private static final String UNITS_PACKAGE_NAME =
			"FifthExersiceReflection.pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
		Constructor<?> unitConstructor = unitClass.getDeclaredConstructor();
		Unit unit = (Unit) unitConstructor.newInstance();
		return unit;
	}
}
