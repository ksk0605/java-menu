package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class InedibleMenus {
    private static final int MAX_INEDIBLE_MENUS = 2;

    List<Menu> menus;

    public InedibleMenus(String menus) {
        this.menus = new ArrayList<>();
        if (!menus.isEmpty()) {
            validateAndCreateMenus(split(menus));
        }
    }

    public boolean isInedibleMenu(Menu menu) {
        return menus.contains(menu);
    }

    private void validateAndCreateMenus(String[] menus) {
        if (menus.length > MAX_INEDIBLE_MENUS) {
            throw new IllegalArgumentException();
        }
        createMenus(menus);
    }

    private void createMenus(String[] menus) {
        for (String menu : menus) {
            this.menus.add(Menu.valueOf(menu.trim()));
        }
    }

    private String[] split(String menus) {
        return menus.split(",");
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
