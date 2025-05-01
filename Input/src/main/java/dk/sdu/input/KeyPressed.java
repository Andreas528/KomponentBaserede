package dk.sdu.input;

import dk.sdu.common.input.IInput;
import dk.sdu.common.data.GameData;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import dk.sdu.common.data.EGameInputs;

public class KeyPressed implements IInput {
    @Override
    public EventType<? extends InputEvent> getInputEvent() {
        return KeyEvent.KEY_PRESSED;
    }

    @Override
    public EventHandler<InputEvent> getInputHandler(GameData gameData) {
        return new EventHandler<InputEvent>() {
            @Override
            public void handle(InputEvent inputEvent) {
                if (inputEvent instanceof KeyEvent keyEvent) {
                    switch (keyEvent.getCode()) {
                        case UP, W -> gameData.getInputs().setInput(EGameInputs.Up, true);
                        case LEFT, A -> gameData.getInputs().setInput(EGameInputs.Left, true);
                        case RIGHT, D -> gameData.getInputs().setInput(EGameInputs.Right, true);
                    }
                }
            }
        };
    }
}
