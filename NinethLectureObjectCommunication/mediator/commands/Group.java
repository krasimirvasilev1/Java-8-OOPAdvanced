package NinethLectureObjectCommunication.mediator.commands;

import NinethLectureObjectCommunication.mediator.interfaces.AttackGroup;
import NinethLectureObjectCommunication.mediator.interfaces.Attacker;
import NinethLectureObjectCommunication.mediator.interfaces.Target;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {
    private List<Attacker> attackerList;

    public Group() {
        this.attackerList = new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackerList.add(attacker);
    }

    @Override
    public void groupTarget(Target target) {
        this.attackerList.forEach(x -> x.setTarget(target));
    }

    @Override
    public void groupAttack() {
        this.attackerList.forEach(Attacker::attack);
    }

    @Override
    public void groupTargetAndAttack(Target target){
        this.attackerList.forEach(x -> x.setTarget(target));
        this.attackerList.forEach(Attacker::attack);
    }
}
