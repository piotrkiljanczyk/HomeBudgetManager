//package pl.coderslab.budgetmanager.model.validation;
//
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PasswordValidator implements ConstraintValidator<Password, String> {
//
//    @Override
//    public void initialize (Password constraintAnnotation) {
//    }
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//
//        List<Character> characterList = new ArrayList<>();
//
//        for (char ch: value.toCharArray()) {
//            characterList.add(ch);
//        }
//
//        if (value.length()<7){
//            return false;
//        }
//        if (value.length()>40){
//            return false;
//        }
//
//        if (characterList.stream().filter(character -> Character.isLowerCase(character)).findFirst().isEmpty()) {
//            return false;
//        }
//
//        if (characterList.stream().filter(character -> Character.isUpperCase(character)).findFirst().isEmpty()) {
//            return false;
//        }
//        if (characterList.stream().filter(character -> Character.isDigit(character)).findFirst().isEmpty()) {
//            return false;
//        }
//        if (characterList.stream().filter(character -> Character.isWhitespace(character)).findFirst().isPresent()) {
//            return false;
//        };
//
//        return true;
//    }
//}
