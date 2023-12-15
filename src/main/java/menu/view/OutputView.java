package menu.view;

import menu.domain.Category;
import menu.domain.CoachMenus;

import java.util.List;

public class OutputView {
    public static void printResult(List<Category> categories, List<CoachMenus> coachMenus) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.print("[ 카테고리");
        for (Category category : categories) {
            System.out.print(" | " + category);
        }
        System.out.print(" ]\n");

        for (CoachMenus coachMenu : coachMenus) {
            System.out.print("[ " + coachMenu.getCoach().getCoachName());
            for (String menu : coachMenu.getMenus()) {
                menu = menu.replace("_", " ");
                System.out.print(" | " + menu);
            }
            System.out.print(" ]\n");
        }

        System.out.println("추천을 완료했습니다.");
    }
}
