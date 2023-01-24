package exercise;

public enum UserCredentialsValidator {

    INSTANCE;

    public boolean isValid(User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) { // Kolejność w tym ma znaczenie, kolejność według ważnośći
            System.out.println("Pusty email - nie mozna dodac uzytkownika");
            return false;
        }
        if (user.getPassword() == null || user.getPassword().isEmpty() ) {
            System.out.println("Puste haslo - nie mozna dodac uzytkownika");
            return false;
        }
        return true;
    }
}
