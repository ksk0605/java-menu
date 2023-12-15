package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final CoachName coachName;
    private InedibleMenus inedibleMenus;
    private final List<String> randomMenus;

    public Coach(CoachName coachName) {
        this.coachName = coachName;
        randomMenus = new ArrayList<>();
    }

    public void recommendMenu(Category category) {
        String randomMenu = Menu.createRandomMenuByCategory(category);

        while (randomMenus.contains(randomMenu) || isInedibleMenu(Menu.fromString(randomMenu))) {
            randomMenu = Menu.createRandomMenuByCategory(category);
        }

        randomMenus.add(randomMenu);
    }

    public void createInedibleMenu(InedibleMenus inedibleMenus) {
        this.inedibleMenus = inedibleMenus;
    }

    public boolean isInedibleMenu(Menu menu) {
        return inedibleMenus.isInedibleMenu(menu);
    }

    public String getCoachName() {
        return coachName.getName();
    }

    public InedibleMenus getInedibleMenus() {
        return inedibleMenus;
    }

    public List<String> getMenus() {
        return randomMenus;
    }
}
