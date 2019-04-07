package Events.ObjectEvents;

import Conditionals.Conditional;
import GameObjects.GameObject;
import GameObjects.ObjectManager;

import java.util.List;

public class Deflect extends DirectionChange{

    double myAdjustmentAngle;

    public Deflect(List<Conditional> conditionals, double angle){
        super(conditionals,180);
    }

    @Override
    public void activate(ObjectManager objectManager){
        objectManager.adjustDirection(myObject, myAdjustmentAngle);
    }

    @Override
    public void activate(double other, ObjectManager objectManager){
        objectManager.adjustDirection(myObject, myAdjustmentAngle);
    }

}
