package FourthExersiceEnumerationsAndAnnotations.inferno_demo.repositories;

import FourthExersiceEnumerationsAndAnnotations.inferno_demo.models.api.WeaponInterface;

import java.util.Map;

public interface Repository<T> {

    void add(T element);


    Map<String, WeaponInterface> findAll();
}
