package dk.sdu.common.data;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class GameInputs {
    private static Map<EGameInputs, Boolean> keys;

    public GameInputs() {
        keys = Collections.synchronizedMap(new EnumMap<>(EGameInputs.class));
    }


    public void setInput(EGameInputs key, boolean b) {
        keys.put(key, b);
    }

    public boolean isDown(EGameInputs key) {
        return keys.getOrDefault(key, false);
    }



}
