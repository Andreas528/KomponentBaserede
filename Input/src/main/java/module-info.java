import dk.sdu.common.input.IInput;
import dk.sdu.input.KeyPressed;
import dk.sdu.input.KeyReleased;

module Input {
    requires Common;
    requires CommonInput;
    requires javafx.graphics;

    provides IInput with KeyPressed, KeyReleased;
}