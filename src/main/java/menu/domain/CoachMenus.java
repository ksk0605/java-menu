package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CoachMenus {
    private final Coach coach;
    private final List<String> menus;

    public CoachMenus(Coach coach, List<Category> categories) {
        this.coach = coach;
        this.menus = new ArrayList<>();
        createMenus(categories);
    }

    public void createMenus(List<Category> categories) {
        for (Category category : categories) {
            String randomMenu = Menu.createRandomMenuByCategory(category);

            while (menus.contains(randomMenu) || coach.isInedibleMenu(Menu.fromString(randomMenu))) {
                randomMenu = Menu.createRandomMenuByCategory(category);
            }

            menus.add(randomMenu);
        }
    }

    public Coach getCoach() {
        return coach;
    }

    public List<String> getMenus() {
        return menus;
    }
}
