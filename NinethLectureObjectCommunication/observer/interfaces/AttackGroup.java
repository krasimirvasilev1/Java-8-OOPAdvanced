package NinethLectureObjectCommunication.observer.interfaces;

public interface AttackGroup {

    void addMember(Attacker attacker);

    void groupTarget(Target target);

    void groupAttack();

    void groupTargetAndAttack(Target target);
}
