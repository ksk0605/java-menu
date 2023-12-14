package menu.domain;

import menu.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Category {
    일식(1), 한식(2), 중식(3), 아시안(4), 양식(5);

    private final int order;
    private static final int maxDuplicates = 2;
    private static final int categorySize = 5;

    Category(int order) {
        this.order = order;
    }

    public static List<Category> createRandomCategories() {
        List<Category> randomCategories = new ArrayList<>();

        while (randomCategories.size() < categorySize) {
            int randomOrder = RandomNumberGenerator.generate();

            // 중복 체크
            int duplicateCount = Collections.frequency(randomCategories, getCategoryByOrder(randomOrder));
            if (duplicateCount < maxDuplicates) {
                randomCategories.add(getCategoryByOrder(randomOrder));
            }
        }

        return randomCategories;
    }

    private static Category getCategoryByOrder(int order) {
        for (Category category : Category.values()) {
            if (category.order == order) {
                return category;
            }
        }
        throw new IllegalArgumentException("Invalid order: " + order);
    }

    public int getOrder() {
        return order;
    }
}
