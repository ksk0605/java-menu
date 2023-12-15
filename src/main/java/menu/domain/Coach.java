package menu.domain;

public class Coach {
    private final CoachName coachName;
    private InedibleMenus inedibleMenus;

    public Coach(CoachName coachName) {
        this.coachName = coachName;
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
}
