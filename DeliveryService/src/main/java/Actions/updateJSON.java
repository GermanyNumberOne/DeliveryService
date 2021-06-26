package Actions;

import Constructor.Context;
import Json.JasonParser;

import java.io.IOException;

public class updateJSON{
    public static void update() {
        try {
            JasonParser.WriteJSON(Context.getService());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
