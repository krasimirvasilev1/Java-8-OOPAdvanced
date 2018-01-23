package NinethExersiceObjectCommunicationAndEvents.kings_gambit.interfaces;

public interface King {

    void addAGuardToTheKing(String guardName);

    void addAFootmanToTheKing(String footmanName);

    void killGuardOrFootman(String name);

    void kingIsUnderAttack();
}
