package menu.view.validator;

public class InputValidator {
    public static void validate(String input) {
        try {
            input.split(",");
        } catch (ArrayIndexOutOfBoundsException e) {
            
        }
    }
}
