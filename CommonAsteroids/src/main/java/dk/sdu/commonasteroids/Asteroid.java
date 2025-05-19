package dk.sdu.commonasteroids;
import dk.sdu.common.data.Entity;

public class Asteroid extends Entity {
    boolean isSplit;

    public boolean isSplit() {
        return isSplit;
    }

    public void setSplit(boolean split) {
        isSplit = split;
    }
}
