package warrior_tests;

import app.contracts.Hero;
import app.core.BaseCommand;
import app.models.participants.AbstractHero;
import app.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;


public class WarriorTests {
    private static final int HERO_HEALTH_MULTIPLIER = 10;
    private static final int LEVEL_UP_MULTIPLIER = 2;
    private final int DAMAGE = 10;
    private Hero warrior;

    @Before
    public void before() {
        this.warrior = new Warrior();
    }

    @Test
    public void testIfTheHeroIsTakingDamageWhenAttacked() {
        this.warrior.takeDamage(DAMAGE);

        Assert.assertEquals("The hero health is different than the expected !!!", 40, this.warrior.getHealth(), 0.1);
    }

    @Test
    public void testIfTheHeroAliveStatusIsTrueAfterInitializing() {
        boolean heroAliveStatus = this.warrior.isAlive();

        Assert.assertEquals("After initializing the hero is not alive !!!", true, heroAliveStatus);
    }

    @Test
    public void testIfTheAliveStatusIsChangingWhenHealthFallUnderZero() {
        this.warrior.setHealth(1);
        this.warrior.takeDamage(10);

        boolean heroAliveStatus = this.warrior.isAlive();

        Assert.assertEquals("The hero alive status is not changing when he is dead !!!", false, heroAliveStatus);
    }

    @Test
    public void testLevelUpMethod() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        this.warrior.setStrength(3);
        this.warrior.setDexterity(4);
        this.warrior.setIntelligence(5);

        // Act
        this.warrior.levelUp();
        int expectedStrength = 3 * LEVEL_UP_MULTIPLIER;
        int actualStrength = this.warrior.getStrength();
        int expectedDexterity = 4 * LEVEL_UP_MULTIPLIER;
        int actualDexterity = this.warrior.getDexterity();
        int expectedIntelligence = 5 * LEVEL_UP_MULTIPLIER;
        int actualIntelligence = this.warrior.getIntelligence();
        double expectedHealth = 3 * LEVEL_UP_MULTIPLIER * HERO_HEALTH_MULTIPLIER;
        double actualHealth = this.warrior.getHealth();

        // Assert
        Assert.assertEquals(expectedStrength, actualStrength);
        Assert.assertEquals(expectedDexterity, actualDexterity);
        Assert.assertEquals(expectedIntelligence, actualIntelligence);
        Assert.assertEquals(expectedHealth, actualHealth, Double.MIN_VALUE);
    }

    @Test
    public void testReceiveRewardMethod() throws NoSuchFieldException, IllegalAccessException {
        double gold = this.getGoldReflection(this.warrior);
        double reward = 1;

        this.warrior.receiveReward(reward);
        double expectedGold = reward + gold;

        double realGold = this.getGoldReflection(this.warrior);

        Assert.assertEquals("The hero is not receiving any rewards", expectedGold, realGold, 0.01);
    }

    private double getGoldReflection(Hero warrior) throws NoSuchFieldException, IllegalAccessException {
        try {
            Class newClass = Warrior.class.getSuperclass();
            Field field = newClass.getDeclaredField("gold");
            field.setAccessible(true);
            return (double) field.get(warrior);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return 0.0;
    }
}
