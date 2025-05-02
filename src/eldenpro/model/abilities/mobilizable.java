package eldenpro.model.abilities;

import eldenpro.model.enemies.enemy;

public interface mobilizable {
    public void climb();

    public void sneak(enemy enemy);

    public void shadowStep(enemy enemy);
}
