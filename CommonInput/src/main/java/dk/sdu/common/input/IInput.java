package dk.sdu.common.input;

import dk.sdu.common.data.GameData;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.InputEvent;

public interface IInput {
    EventType<? extends InputEvent> getInputEvent();

    EventHandler<InputEvent> getInputHandler(GameData gameData);
}
