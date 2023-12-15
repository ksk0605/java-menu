package menu.view;

import menu.domain.Coach;
import menu.domain.CoachName;
import menu.domain.InedibleMenus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static Scanner scan = new Scanner(System.in);

    public static List<Coach> inputCoaches() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = scan.nextLine();
        String[] coachNames = input.split(",");
        if (coachNames.length < 2) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.");
        }
        if (coachNames.length > 4) {
            throw new IllegalArgumentException("[ERROR] 코치는 최대 4명까지 입력할 수 있습니다.");
        }
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            coaches.add(new Coach(new CoachName(coachName)));
        }
        return coaches;
    }

    public static void inputInedibleMenus(List<Coach> coaches) {
        for (Coach coach : coaches) {
            System.out.println(coach.getCoachName() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            String input = scan.nextLine();
            coach.createInedibleMenu(new InedibleMenus(input));
        }
        System.out.println();
    }
}
