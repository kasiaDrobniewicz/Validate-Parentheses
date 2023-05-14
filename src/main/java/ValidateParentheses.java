import java.util.*;

public class ValidateParentheses {

    private static List<Character> openingParenthesis = Arrays.asList('(','{','[');
    private static List<Character> closingParenthesis = Arrays.asList(')','}',']');

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter the parentheses: ");
        String parentheses = userInput.next();

        System.out.println(isValidateParentheses(parentheses));
    }

    public static boolean isValidateParentheses(String word) {
        if (word == null)
            throw new IllegalArgumentException("Null is not a valid input");

        List<Character> parenthesisList = new ArrayList<>();

        for (int i = 0; i <= word.length() -1; i++) {
            if (!isInputValid(word.charAt(i))) return false;
            if (isParenthesis(word.charAt(i))){
                if (openingParenthesis.contains(word.charAt(i))){
                    parenthesisList.add(word.charAt(i));
                } else if (closingParenthesis.contains(word.charAt(i))){
                    char parenthesis = selectTheAppropriateParenthesis(word.charAt(i));
                    if (parenthesis == parenthesisList.get(parenthesisList.size() -1)){
                        parenthesisList.remove(parenthesisList.size() -1);
                    }
                } else {
                    return false;
                }
            }
        }
        if (parenthesisList.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isParenthesis(char c){
        if((openingParenthesis.contains(c) || closingParenthesis.contains(c))) {
            return true;
        }
        return false;
    }

    public static Character selectTheAppropriateParenthesis (char c) {
        Map<Character,Character> parenthesis = new HashMap<>();
        parenthesis.put(')','(');
        parenthesis.put('}','{');
        parenthesis.put(']','[');

        return parenthesis.get(c);
    }

    public static boolean isInputValid (char c) {
        if (!openingParenthesis.contains(c) &&
                !closingParenthesis.contains(c)) {
            System.out.println("Incorrect input");
            return false;
        } else return true;
    }
}
