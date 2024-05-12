import java.util.Scanner;

public class Posting {

    Scanner input = new Scanner(System.in);
    private Fallowing fallowing;

    Posting() {
        fallowing = new Fallowing();
    }

    public void create_poste(int user) {
        int count_text = 0;
        System.out.println("please enter your text when finish tipe exit");
        Data.users[user].creat_poste_object();
        for (int i = 0; i < 100; i++) {
            Data.users[user].getPoste()[Data.users[user].getPoste_number()].setText(input.next(), i);
            count_text = count_text + Data.users[user].getPoste()[Data.users[user].getPoste_number()].getText(i).length();
            if (Data.users[user].getPoste()[Data.users[user].getPoste_number()].getText(i).equals("exit")) {
                Data.users[user].getPoste()[Data.users[user].getPoste_number()].setText("", i);
                break;
            }
        }
        if (count_text > 200) {
            System.out.println("you cant creat poste more 200 caracter ");
            create_poste(user);
        } else {
            System.out.println("Your post in created");
            Data.users[user].setPoste_number(Data.users[user].getPoste_number() + 1);
        }
    }

    private void show_like_person(int post, int user) {
        for (int i = 0; i < Data.users[user].getPoste()[post].getLike(); i++) {
            System.out.println(Data.users[Data.users[user].getPoste()[post].getLike_person(i)].getUser_name());
        }
    }

    public void show_poste(int user ,boolean flage) {
        for (int i = 0; i < Data.users[user].getPoste_number(); i++) {
            System.out.print((i + 1) + ".");
            for (int j = 0; j < 100; j++) {
                System.out.print(Data.users[user].getPoste()[i].getText(j) + " ");
                if (Data.users[user].getPoste()[i].getText(j).isEmpty()) {
                    break;
                }
            }
            System.out.print("\n");
        }
        if (flage) {
            System.out.println("please enter poste number ");
            int poste = input.nextInt();
            while (true) {
                System.out.println("1.show like \n2.show comment\n3.exit");
                int option = input.nextInt();
                if (option == 1) {
                    show_like_person(poste - 1, user);
                } else if (option == 2) {
                    see_cooment(poste-1, user);
                } else if (option == 3) {
                    break;
                }
            }
        }
    }

    private void organize_poste(int poste_delete) {
        System.out.println("Are you sure delete poset send 1");
        if (input.nextInt() != 1)
            return;
        for (int i = poste_delete - 1; i < Data.users[Data.getUser_active()].getPoste_number() - 1; i++) {
            for (int j = 0; j < 100; j++) {
                Data.users[Data.getUser_active()].getPoste()[i].setText(Data.users[Data.getUser_active()].getPoste()[i + 1].getText(j), j);
            }

        }
    }

    public void delete_poste() {
        show_poste(Data.getUser_active(),false);
        System.out.println("chose your poste");

        organize_poste(input.nextInt());
        Data.users[Data.getUser_active()].setPoste_number(Data.users[Data.getUser_active()].getPoste_number() - 1);

    }


    private void creat_delete_text(String[] delete_text) {
        for (int i = 0; i < 10; i++) {
            delete_text[i] = input.next();
            if (delete_text[i].equals("exit")) {
                delete_text[i] = "";
                break;
            }
        }
    }

    private void creat_add_text(String[] add_text) {
        for (int i = 0; i < 10; i++) {
            add_text[i] = input.next();
            if (add_text[i].equals("exit")) {
                add_text[i] = "";
                break;
            }
        }
    }

    private void delete_add(int poste, String[] delete_text, String[] add_text) {
        for (int i = 0; i < Data.users[Data.getUser_active()].getPoste()[poste - 1].getText_array().length; i++) {
            for (int j = 0; j < 10; j++) {
                if (Data.users[Data.getUser_active()].getPoste()[poste - 1].getText(i).equals(delete_text[j])) {
                    Data.users[Data.getUser_active()].getPoste()[poste - 1].setText(add_text[j], i);
                    return;
                }
            }

        }
    }

    private void edit_text_poste(int poste) {
        System.out.println("whate text wante delete when finish type exit ");
        String[] delete_text = new String[10];
        creat_delete_text(delete_text);
        System.out.println("whate text want add when finish type exit");
        String[] add_text = new String[10];
        creat_add_text(add_text);
        delete_add(poste, delete_text, add_text);

    }

    public void edit_poste() {
        show_poste(Data.getUser_active(),false);
        System.out.println("chose your poste");
        edit_text_poste(input.nextInt());
        System.out.println("1. edit again");
        if (input.nextInt()==1)
            edit_poste();
    }

    private void like_poste(int user, int poste) {
        Data.users[user].getPoste()[poste].setLike_person(Data.getUser_active());
        Data.users[user].getPoste()[poste].setLike(Data.users[user].getPoste()[poste].getLike() + 1);
    }


    private void see_cooment(int post, int user) {
        for (int i = 0; i < Data.users[user].getPoste()[post].getCommente_counte(); i++) {
            System.out.print(Data.users[user].getPoste()[post].getComment_person()[i] + ": ");
            for (int j = 0; j < 10; j++) {
                System.out.print(Data.users[user].getPoste()[post].getComment()[i][j]);
                if (Data.users[user].getPoste()[post].getComment()[i][j].isEmpty())
                    break;
            }
            System.out.println();
        }
    }

    private void comment_fallowing_poste(int poste, int user) {
        System.out.println("please enter your commente");
        Data.users[user].getPoste()[poste].setComment_person(Data.users[Data.getUser_active()].getUser_name());
        for (int i = 0; i < 10; i++) {
            String word = input.next();
            Data.users[user].getPoste()[poste].setComment(word, i);
            if (word.equals("exit")) {
                Data.users[user].getPoste()[poste].setComment("", i);
                break;
            }
        }
        Data.users[user].getPoste()[poste].setCommente_counte(Data.users[user].getPoste()[poste].getCommente_counte() + 1);
    }

    private void intraction_menue(int poste, int user) {
        while (true) {
            System.out.println("1. like poste\n2.comment in tnis poste\n3.see like poste\n4.see comment\n5.exit");
            int option = input.nextInt();
            switch (option) {
                case 1: {
                    like_poste(user - 1, poste - 1);
                    break;
                }
                case 2: {
                    comment_fallowing_poste(poste - 1, user - 1);
                    break;
                }
                case 3: {
                    show_like_person(poste - 1, user - 1);
                    break;
                }
                case 4: {
                    see_cooment(poste - 1, user - 1);
                }
            }
            if (option == 5)
                break;
        }
    }

    public void see_fallowing_poste() {
        fallowing.show_fallowing();
        System.out.println("for see fallowing username poset press number across acount");
        int user = input.nextInt();
        show_poste(Data.users[Data.getUser_active()].getFallowing(user),false);
        System.out.println("you cane chose poste for like ore comment press its number ");
        int poste = input.nextInt();
        if (poste<=Data.users[Data.users[Data.getUser_active()].getFallowing(user)].getPoste_number())
        intraction_menue(poste, user);
    }


}
