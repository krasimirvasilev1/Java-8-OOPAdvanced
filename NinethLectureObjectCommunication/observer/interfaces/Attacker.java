package NinethLectureObjectCommunication.observer.interfaces;

public interface Attacker extends Observer{
    void attack();
    void setTarget(Target target);
}
