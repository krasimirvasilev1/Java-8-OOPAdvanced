package FourthExersiceEnumerationsAndAnnotations.inferno_demo.repositories;

import FourthExersiceEnumerationsAndAnnotations.inferno_demo.models.api.WeaponInterface;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WeaponRepository<T extends WeaponInterface> implements Repository<WeaponInterface> {
    private Map<String, WeaponInterface> weapons;

    public WeaponRepository() {
        this.weapons = new HashMap<>();
    }

    @Override
    public void add(WeaponInterface weaponInterface) {
        this.weapons.putIfAbsent(weaponInterface.getName(), weaponInterface);
    }

    @Override
    public Map<String, WeaponInterface> findAll() {
        return Collections.unmodifiableMap(this.weapons);
    }
}