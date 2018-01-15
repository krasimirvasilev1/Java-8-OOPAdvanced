package assembler_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.*;
import panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

public class AssemblerTests {
    private Assembler assembler;

    private AttackModifyingPart part1;
    private DefenseModifyingPart part2;
    private HitPointsModifyingPart part3;

    private AttackModifyingPart part4;
    private DefenseModifyingPart part5;
    private HitPointsModifyingPart part6;


    @Before
    public void before() {
        this.assembler = new VehicleAssembler();
        part1 = Mockito.mock(AttackModifyingPart.class);
        part2 = Mockito.mock(DefenseModifyingPart.class);
        part3 = Mockito.mock(HitPointsModifyingPart.class);

        part4 = Mockito.mock(AttackModifyingPart.class);
        part5 = Mockito.mock(DefenseModifyingPart.class);
        part6 = Mockito.mock(HitPointsModifyingPart.class);

        this.assembler.addArsenalPart(part1);
        this.assembler.addShellPart(part2);
        this.assembler.addEndurancePart(part3);

        this.assembler.addArsenalPart(part4);
        this.assembler.addShellPart(part5);
        this.assembler.addEndurancePart(part6);

        Mockito.when(this.part1.getAttackModifier()).thenReturn(1_000_000_000);
        Mockito.when(this.part2.getDefenseModifier()).thenReturn(2_000_000_000);
        Mockito.when(this.part3.getHitPointsModifier()).thenReturn(2_000_000_000);

        Mockito.when(this.part4.getAttackModifier()).thenReturn(2_000_000_000);
        Mockito.when(this.part5.getDefenseModifier()).thenReturn(1_000_000_000);
        Mockito.when(this.part6.getHitPointsModifier()).thenReturn(1_000_000_000);
    }

    @Test
    public void isItAddingCorrectlyArsenalPart() throws NoSuchFieldException, IllegalAccessException {

        Field field = this.assembler.getClass().getDeclaredField("arsenalParts");
        field.setAccessible(true);
        List<Part> partList = (List<Part>) field.get(this.assembler);

        int expectedValue = 2;
        Assert.assertEquals("Its not adding correctly", expectedValue, partList.size());
    }

    @Test
    public void isItAddingCorrectlyShellPart() throws NoSuchFieldException, IllegalAccessException {

        Field field = this.assembler.getClass().getDeclaredField("shellParts");
        field.setAccessible(true);
        List<Part> partList = (List<Part>) field.get(this.assembler);

        int expectedValue = 2;
        Assert.assertEquals("Its not adding correctly", expectedValue, partList.size());
    }

    @Test
    public void isItAddingCorrectlyHitpointsPart() throws NoSuchFieldException, IllegalAccessException {

        Field field = this.assembler.getClass().getDeclaredField("enduranceParts");
        field.setAccessible(true);
        List<Part> partList = (List<Part>) field.get(this.assembler);

        int expectedValue = 2;
        Assert.assertEquals("Its not adding correctly", expectedValue, partList.size());
    }

    @Test
    public void isItReturningCorrectTotalAttackModification(){
        long value = this.assembler.getTotalAttackModification();

        Assert.assertEquals("Its not returning correct result",3_000_000_000L,value);
    }

    @Test
    public void isItReturningCorrectTotalHitPointModification(){
        long value = this.assembler.getTotalHitPointModification();

        Assert.assertEquals("Its not returning correct result",3_000_000_000L,value);
    }

    @Test
    public void isItReturningCorrectTotalDefenseModification(){
        long value = this.assembler.getTotalDefenseModification();

        Assert.assertEquals("Its not returning correct result",3_000_000_000L,value);
    }

    @Test
    public void isItReturningCorrectTotalWeight(){
        Mockito.when(this.part1.getWeight()).thenReturn(100000000.0);
        Mockito.when(this.part2.getWeight()).thenReturn(200000000.0);
        Mockito.when(this.part3.getWeight()).thenReturn(300000000.0);

        double value = this.assembler.getTotalWeight();

        Assert.assertEquals("Its not returning correct weight result",value,600_000_000,0.01);
    }

    @Test
    public void isItReturningCorrectTotalPrice(){
        Mockito.when(this.part1.getPrice()).thenReturn(BigDecimal.valueOf(100000000.0));
        Mockito.when(this.part2.getPrice()).thenReturn(BigDecimal.valueOf(200000000.0));
        Mockito.when(this.part3.getPrice()).thenReturn(BigDecimal.valueOf(300000000.0));

        Mockito.when(this.part4.getPrice()).thenReturn(BigDecimal.valueOf(100000000.0));
        Mockito.when(this.part5.getPrice()).thenReturn(BigDecimal.valueOf(200000000.0));
        Mockito.when(this.part6.getPrice()).thenReturn(BigDecimal.valueOf(300000000.0));

        BigDecimal value = new BigDecimal(String.valueOf(this.assembler.getTotalPrice()));

        Assert.assertEquals("Its not returning correct price result",value,BigDecimal.valueOf(1200000000));
    }
}
