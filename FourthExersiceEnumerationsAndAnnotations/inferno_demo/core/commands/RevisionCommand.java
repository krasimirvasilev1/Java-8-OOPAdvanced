package FourthExersiceEnumerationsAndAnnotations.inferno_demo.core.commands;

import FourthExersiceEnumerationsAndAnnotations.inferno_demo.annotations.CustomAnnotation;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.core.BaseCommand;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.models.impl.Weapon;

public class RevisionCommand extends BaseCommand {
    @Override
    public String execute() {
        CustomAnnotation annotation = Weapon.class.getAnnotation(CustomAnnotation.class);
        return String.format("Revision: %s", annotation.revision());
    }
}
