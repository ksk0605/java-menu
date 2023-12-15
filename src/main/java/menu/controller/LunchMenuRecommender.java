package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.util.RandomNumberGenerator;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LunchMenuRecommender {
    private static final int CATEGORY_SIZE = 5;

    public void start() {
        System.out.println("점심 메뉴 추천을 시작합니다.");

        List<Coach> coaches = InputView.inputCoaches();
        InputView.inputInedibleMenus(coaches);

        List<Category> categories = new ArrayList<>();

        while (categories.size() < CATEGORY_SIZE) {
            int randomOrder = RandomNumberGenerator.generate();

            // 중복 체크
            Category randomCategory = Category.getCategoryByOrder(randomOrder);
            int duplicateCount = Collections.frequency(categories, randomCategory);
            if (duplicateCount < 2) {
                categories.add(randomCategory);

                for (Coach coach : coaches) {
                    coach.recommendMenu(randomCategory);
                }
            }
        }

        OutputView.printResult(categories, coaches);
    }
}
