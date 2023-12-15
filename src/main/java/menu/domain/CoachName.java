package menu.domain;

public class CoachName {
    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 4;

    private final String name;

    public CoachName(String name) {
        validateName(name);
        this.name = name;
    }

    public void validateName(String name) {
        if (isOutOfRangeName(name)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOutOfRangeName(String name) {
        return name.length() < MIN_LENGTH || name.length() > MAX_LENGTH;
    }

    public String getName() {
        return name;
    }
}
