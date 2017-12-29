package FourthExersiceEnumerationsAndAnnotations.inferno_demo.core.commands;

import FourthExersiceEnumerationsAndAnnotations.inferno_demo.annotations.CustomAnnotation;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.core.BaseCommand;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.models.impl.Weapon;

public class DescriptionCommand extends BaseCommand {
    @Override
    public String execute() {
        CustomAnnotation annotation = Weapon.class.getAnnotation(CustomAnnotation.class);
        return String.format("Class description: %s", annotation.description());
    }
}
