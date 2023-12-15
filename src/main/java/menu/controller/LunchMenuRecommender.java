package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.CoachMenus;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LunchMenuRecommender {
    public void start() {
        System.out.println("점심 메뉴 추천을 시작합니다.");

        List<Coach> coaches = InputView.inputCoaches();
        InputView.inputInedibleMenus(coaches);

        List<Category> categories = Category.createRandomCategories();

        List<CoachMenus> coachMenus = new ArrayList<>();
        for (Coach coach : coaches) {
            coachMenus.add(new CoachMenus(coach, categories));
        }

        OutputView.printResult(categories, coachMenus);
    }
}
