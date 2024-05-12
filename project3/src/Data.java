
import java.util.Scanner;

public class Data {
    Scanner input = new Scanner(System.in);
    private static int number_user;
    private static int user_active;

    public static int getUser_active() {
        return user_active;
    }

    public static int getNumber_user() {
        return number_user;
    }

    public static User[] users = new User[100];

    private boolean user_flage;
    private boolean user_logout_flage;

    public boolean getUser_flage() {
        return user_flage;
    }

    public void setUser_flage(boolean user_flage) {
        this.user_flage = user_flage;
    }

    Data() {
        number_user = 0;
        user_flage = true;
        user_logout_flage=false;
    }

    public boolean isUser_logout_flage() {
        return user_logout_flage;
    }

    public void setUser_logout_flage(boolean user_logout_flage) {
        this.user_logout_flage = user_logout_flage;
    }

    int search_acount(String username) {
        for (int i = 0; i < number_user; i++) {
            if (username.equals(users[i].getUser_name())) {
                return i;
            }
        }
        return -1;
    }

    public void login_menu() {
        if (number_user==0)
        {
            System.out.println("we dont have account to login please sining");
            return;
        }
        System.out.println("pleas enter your username");
        String username = input.next();
        System.out.println("pleas enter your password");
        String password = input.next();
        int user = search_acount(username);
        if (user == -1) {
            System.out.println("your username or password is not true1");
            login_menu();
        } else {
            if (password.equals(users[user].getPassword())){
                System.out.println("wellcom");
                user_active = user;
            } else {
                System.out.println("your username or password is not true");
                login_menu();
            }
        }
        user_flage = false;
    }

    private boolean chek_usermane(String new_username) {
        for (int i = 0; i < number_user; i++) {
            if (users[i].getUser_name().equals(new_username))
                return true;
        }
        return false;
    }

    private boolean check_password(String new_password) {
        System.out.println("plaes enter password egain");
        String password_check = input.next();
        if (password_check.equals(new_password)) {
            return true;
        }
        return false;
    }

    private String creat_passvord() {
        System.out.println("pleas enter your password\ninput 8 cracter or more");
        String new_password = input.next();
        if (new_password.length()<8) {
            System.out.println("pleas enter 8 cracter or more");
            creat_passvord();
        } else {
            if (check_password(new_password)) {
                System.out.println("wlcome");
                return new_password;
            } else {
                System.out.println("this two password not mach");
                creat_passvord();

            }
        }
        return null;
    }

    void singin_menu() {

        users[number_user] = new User();
        System.out.println("pleas emter your username");
        String new_username = input.next();
        if (chek_usermane(new_username)) {
            System.out.println("this usermane is exist pleas another username");
            singin_menu();
        } else {
            users[number_user].setUser_name(new_username);

            users[number_user].setPassword(creat_passvord());
            user_active = number_user;
            number_user++;
        }
        user_flage = false;
    }


    public void set_change_boi() {
        System.out.println("please enter your bio when finish type exit ");
        for (int i = 0; i < 10; i++) {
            String word = input.next();
            users[user_active].setBio(word, i);
            if (word.equals("exit")) {
                break;
            }
            users[user_active].bio_count++;

        }
    }

}
