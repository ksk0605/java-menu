package menu;

import menu.controller.LunchMenuRecommender;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LunchMenuRecommender lunchMenuRecommender = new LunchMenuRecommender();
        lunchMenuRecommender.start();
    }
}
