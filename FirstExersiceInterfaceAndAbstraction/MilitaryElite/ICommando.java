package FirstExersiceInterfaceAndAbstraction.MilitaryElite;

import java.util.List;

public interface ICommando {

    List<Mission> getMissions();

    void addMission(Mission mission);
}
