package ECS;

import Components.BasicComponent;
import Components.ImpassableComponent;

import java.util.ArrayList;
import java.util.Set;

public class CollisionDetector {
    private EntityManager myEntityManager;

    public CollisionDetector(EntityManager entityManager) {
        myEntityManager = entityManager;
    }

    public Integer[] getImpassableColliders(Integer entity, Set<Integer> allEntities) {
        ArrayList<Integer> impassables = new ArrayList<>();
/*        for (Integer other : allEntities) {
            if (other.equals(entity))
                continue;
            var impassableComponent = myEntityManager.getComponent(other, ImpassableComponent.class);
            if (impassableComponent != null && impassableComponent.getImpassable())
                impassables.add(other);
        }*/
        return impassables.toArray(new Integer[0]);
    }

                           //FIXME do we need to detect whether the collision is right, top, left, or bottom based on solely the velocity angle?
    public boolean collides(Integer collider, Integer target) {
        var colliderComponent = myEntityManager.getComponent(collider, BasicComponent.class);
        var targetComponent = myEntityManager.getComponent(target, BasicComponent.class);
        return colliderComponent.getX() < targetComponent.getX() + targetComponent.getWidth() &&
                colliderComponent.getX() + colliderComponent.getWidth() > targetComponent.getX() &&
                colliderComponent.getY() < targetComponent.getY() + targetComponent.getHeight() &&
                colliderComponent.getY() + colliderComponent.getHeight() > targetComponent.getY();
            /*return collideFromLeft(collider, target) ||
                    //collideFromRight(component1, component2) ||
                    //collideFromBottom(component1, component2) ||
                    collideFromTop(collider, target);*/
            //FIXME uncomment methods above
    }

    //FIXME no collide from right (CollideFromRight event uses this method)
    public boolean collideFromLeft(Integer collider, Integer target) {
        var colliderComponent = myEntityManager.getComponent(collider, BasicComponent.class); //FIXME these two lines duplicated in all collision methods
        var targetComponent = myEntityManager.getComponent(target, BasicComponent.class);
        double width1 = colliderComponent.getWidth();
        double x1 = colliderComponent.getX();
        double x2 = targetComponent.getX();
        double height1 = colliderComponent.getHeight();
        double height2 = targetComponent.getHeight();
        double y1 = colliderComponent.getY();
        double y2 = targetComponent.getY();
        return x1 + width1 >= x2 && !(y2 >= height1 + y1 || y2 <= y1 - height2);
    }

    //FIXME no collide from bottom (CollideFromBottom event uses this method)
    public boolean collideFromTop(Integer collider, Integer target) {
        var colliderComponent = myEntityManager.getComponent(collider, BasicComponent.class);
        var targetComponent = myEntityManager.getComponent(target, BasicComponent.class);
        double height1 = colliderComponent.getHeight();
        double y1 = colliderComponent.getY();
        double y2 = targetComponent.getY();
        double width1 = colliderComponent.getWidth();
        double width2 = colliderComponent.getWidth();
        double x1 = colliderComponent.getX();
        double x2 = colliderComponent.getX();
        return y1 + height1>= y2 && !(x2 >= width1 + x1 || x2 <= x1 - width2);
    }
}
