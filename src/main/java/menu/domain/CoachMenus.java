package menu.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoachMenus {
    private final Coach coach;
    private final Set<String> menus;

    public CoachMenus(Coach coach, List<Category> categories) {
        this.coach = coach;
        this.menus = new HashSet<>();
        createMenus(categories);
    }

    public void createMenus(List<Category> categories) {
        for (Category category : categories) {
            String randomMenu = Menu.createRandomMenuByCategory(category);

            while (menus.contains(randomMenu) || coach.isInedibleMenu(Menu.valueOf(randomMenu))) {
                randomMenu = Menu.createRandomMenuByCategory(category);
            }

            menus.add(randomMenu);
        }
    }

    public Coach getCoach() {
        return coach;
    }

    public Set<String> getMenus() {
        return menus;
    }
}
