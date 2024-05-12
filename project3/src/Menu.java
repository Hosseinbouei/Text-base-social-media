import java.util.Scanner;

public class Menu {
    Scanner input=new Scanner(System.in);
    Posting posting = new Posting();
    Fallowing fallowing = new Fallowing();
    Data data = new Data();

    public void show_login_menu()
    {
        while (data.getUser_flage()) {
            System.out.println("1.login\n2.sign in");
            switch (input.next())
            {
                case "1":
                {
                    data.login_menu();
                    break;
                }
                case "2":
                {
                    data.singin_menu();
                    break;
                }
                default:{
                    System.out.println("pleasr enter correct number");
                }
            }
        }
        show_user_menu();
    }
    public void show_option_fallow() {
        System.out.println("1.search user\n2.see fallowing\n3.see fallower\n4.unfallow\n5.exit");
        switch (input.next()) {
            case "1": {
                fallowing.search();
                break;
            }
            case "2": {
                fallowing.see_fallowing();
                break;
            }
            case "3": {
                fallowing.see_fallower();
                break;
            }
            case "4":{
                fallowing.unfallow_chose_account();
                break;
            }
            case "5":{
                show_user_menu();
                break;
            }
            default:{
                System.out.println("please enter correct number");
                show_option_fallow();
            }
        }
    }
    public void poste_menu() {
        System.out.println("1.creat post\n2.delete poste\n3.edit poste\n4.see fallowing poste\n5.show your poste\n6.exit");
        switch (input.next()) {
            case "1": {
                posting.create_poste(Data.getUser_active());
                break;
            }
            case "2": {
                posting.delete_poste();
                break;
            }
            case "3": {
                posting.edit_poste();
                break;
            }
            case "4": {
                posting.see_fallowing_poste();
                break;
            }
            case "5": {
                posting.show_poste(Data.getUser_active(),true);
                break;
            }
            case "6":{
                show_user_menu();
                break;
            }
            default:{
                System.out.println("please enter correct number");
                poste_menu();
            }
        }
    }
    public void show_user_menu()
    {
        while (!data.isUser_logout_flage()) {
            System.out.println("1.post\n2.fallow option\n3.set or change bio\n4.see your profile\n5.logout\n6.exti");
            switch (input.next()) {
                case "1": {
                    poste_menu();
                    break;
                }
                case "2": {
                    show_option_fallow();
                    break;
                }
                case "3": {
                    data.set_change_boi();
                    break;
                }
                case "4": {
                    fallowing.show_profile(Data.getUser_active());
                    break;
                }
                case "5":{
                    data.setUser_flage(true);
                    show_login_menu();
                    break;
                }case "6":{
                    data.setUser_logout_flage(true);
                    break;
                }
                default:{
                    System.out.println("please enter correct number");
                }
            }
        }
    }
}
