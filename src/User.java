public class User {
    public static void main(String[] args) {
        String login = "Anna";
        String password = "12345";
        String confirmPassword = "12345";
        System.out.println(check(login, password, confirmPassword));
        System.out.println();
    }

    public static boolean included(String str) {
        String alp = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";
        for (int i = 0; i < str.length(); i++) {
            if (!(alp.contains(Character.toString(str.charAt(i))))) {
                return false;
            }
        }
        return true;
    }


    public static boolean check(String login, String password, String confirmPassword) {
        try {
            if (!(login.length() < 20)) {
                throw new WrongLoginException("Логин не соответствует требованиям. ");
            }

            boolean a = included(login);
            if (!a) {
                throw new WrongLoginException("Логин не соответствует требованиям. ");
            }

            if (!(password.length() < 20)) {
                throw new WrongPasswordException("Пароль не соответствует требованиям. ");
            }

            boolean b = included(password);
            if (!b) {
                throw new WrongLoginException("Пароль не соответствует требованиям. ");
            }

            if (!password.equals(confirmPassword)) throw new WrongPasswordException("Пароли не совпадают. ");
        } catch (WrongLoginException | WrongPasswordException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
}