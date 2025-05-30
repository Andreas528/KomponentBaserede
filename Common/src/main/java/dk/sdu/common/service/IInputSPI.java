package dk.sdu.common.service;

import dk.sdu.common.data.GameData;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.InputEvent;

/**
 * Interface for handling input events in the game.
 */

public interface IInputSPI {
    EventType<? extends InputEvent> getInputEvent();

    EventHandler<InputEvent> getInputHandler(GameData gameData);
}
