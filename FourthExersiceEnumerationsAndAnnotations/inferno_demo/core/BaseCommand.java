package FourthExersiceEnumerationsAndAnnotations.inferno_demo.core;

import FourthExersiceEnumerationsAndAnnotations.inferno_demo.annotations.Inject;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.models.api.WeaponInterface;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.repositories.Repository;

public abstract class BaseCommand implements Executable {

    @Inject
    private String[] params;
    @Inject
    private Repository<WeaponInterface> weaponRepository;

    protected BaseCommand() {
    }

    public String[] getParams() {
        return this.params;
    }

    public Repository<WeaponInterface> getWeaponRepository() {
        return this.weaponRepository;
    }
}
