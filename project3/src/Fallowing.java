import java.util.InputMismatchException;
import java.util.Scanner;

public class Fallowing {

    Scanner input = new Scanner(System.in);


    private void fallowing(int user) {
        Data.users[Data.getUser_active()].setFallowing(Data.users[Data.getUser_active()].getFallowing_number(),user);
        Data.users[user].setFallower(Data.users[user].getFallower_number(),Data.getUser_active());
        Data.users[user].setFallower_number(Data.users[user].getFallower_number() + 1);
        Data.users[Data.getUser_active()].setFallowing_number(Data.users[Data.getUser_active()].getFallowing_number() + 1);
    }

    private boolean check_fallow(int user) {
        for (int i = 0; i < Data.users[user].getFallower_number(); i++) {
            if (Data.users[user].getFallower(i) == Data.getUser_active())
                return false;
        }
        return true;
    }

    public void show_profile(int user) {
        System.out.print("username: " + Data.users[user].getUser_name() + "\n" + "bio: ");
        for (int i = 0; i < Data.users[Data.getUser_active()].bio_count; i++) {
            System.out.print(Data.users[Data.getUser_active()].getBio(i) + " ");
        }
        System.out.println("\nfallower: " + Data.users[user].getFallower_number() + "\nfallowing: " + Data.users[user].getFallowing_number() + "\npost: " +
                Data.users[user].getPoste_number());
    }

    public void search() {
        System.out.println("please enter username");
        String useranme = input.next();
        for (int i = 0; i < Data.getNumber_user(); i++) {
            if (i != Data.getUser_active()) {
                if (useranme.equals(Data.users[i].getUser_name())) {
                    System.out.println("find this username");
                    show_profile(i);
                    if (check_fallow(i)) {
                        System.out.println(" you wante fallow this username press 1");
                        if (input.nextInt() == 1) {
                            fallowing(i);
                        }
                    }

                    return;
                }
            }
        }
        System.out.println("its username is not exist");
    }

    public void show_fallowing() {
        for (int i = 0; i < Data.users[Data.getUser_active()].getFallowing_number(); i++) {
            System.out.println((i + 1) + ": " + Data.users[Data.users[Data.getUser_active()].getFallowing(i)].getUser_name());

        }
    }

    public void see_fallowing() {
        show_fallowing();
        System.out.println("if you wante see profile acount press number account");
        int acount = input.nextInt();
        if (acount - 1 < Data.users[Data.getUser_active()].getFallowing_number() && acount - 1 >= 0) {
            show_profile(Data.users[Data.getUser_active()].getFallowing(acount - 1));
        }
    }

    public void see_fallower() {
        for (int i = 0; i < Data.users[Data.getUser_active()].getFallower_number(); i++) {
            System.out.println((i + 1) + ": " + Data.users[Data.users[Data.getUser_active()].getFallower(i)].getUser_name());
        }
        System.out.println("if you wante see profile acount press number account");
        int acount = input.nextInt();
        if (acount - 1 < Data.users[Data.getUser_active()].getFallower_number() && acount - 1 >= 0) {
            show_profile(Data.users[Data.getUser_active()].getFallower(acount - 1));
        }
    }
    private void set_fallower_fallowing(int account)
    {
        User fallower=Data.users[Data.users[Data.getUser_active()].getFallowing(account)];
        boolean flage=false;
        for (int i = 0; i <fallower.getFallower_number(); i++) {
            if (flage)
            {
                fallower.setFallower(i,fallower.getFallower(i+1));
                continue;
            }
            if (Data.users[fallower.getFallower(i)].getUser_name().equals(Data.users[Data.getUser_active()].getUser_name()))
            {
                flage=true;
            }

        }
        fallower.setFallower_number(fallower.getFallower_number()-1);
    }
    private void unfallow(int account)
    {
        set_fallower_fallowing(account);
        for (int i = account; i <Data.users[Data.getUser_active()].getFallowing_number()-1; i++) {
            Data.users[Data.getUser_active()].setFallowing(i,Data.users[Data.getUser_active()].getFallowing(i+1));
        }
        Data.users[Data.getUser_active()].setFallowing_number(Data.users[Data.getUser_active()].getFallowing_number()-1);

    }
    public void unfallow_chose_account()
    {
        show_fallowing();
        System.out.println("please chose username enter its number");
        int acount;
        try {
             acount=input.nextInt();
        }catch (InputMismatchException e)
        {
            System.out.println("enter number");
             acount=input.nextInt();
        }
        if (acount - 1 < Data.users[Data.getUser_active()].getFallowing_number() && acount - 1 >= 0) {
            unfallow(acount-1);
        }else {
            System.out.println("please enter true number");
            unfallow_chose_account();
        }
    }

}
