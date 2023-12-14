package menu.domain;

public class Coach {
    private CoachName coachName;
    private InedibleMenus inedibleMenus;

    public boolean isInedibleMenu(Menu menu) {
        return inedibleMenus.isInedibleMenu(menu);
    }

    public CoachName getCoachName() {
        return coachName;
    }

    public InedibleMenus getInedibleMenus() {
        return inedibleMenus;
    }
}
