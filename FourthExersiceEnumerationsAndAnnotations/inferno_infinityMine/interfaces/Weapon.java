package FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.interfaces;

import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.enums.GemType;

public interface Weapon {

    void add (int socketIndex , GemType gemType);

    void remove (int socketIndex);

    int compareTo (Weapon weapon);

    double getItemLevel();
}
