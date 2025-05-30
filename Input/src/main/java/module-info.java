import dk.sdu.common.service.IInputSPI;
import dk.sdu.input.KeyPressed;
import dk.sdu.input.KeyReleased;

module Input {
    requires Common;
    requires javafx.graphics;

    provides IInputSPI with KeyPressed, KeyReleased;
}