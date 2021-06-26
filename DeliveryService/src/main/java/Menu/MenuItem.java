package Menu;

import Actions.Action;

import java.util.List;

public class MenuItem {
    private String name;//NAME OF THE ACTION
    private Action action;//ACTION

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
