

public class User {
    private String user_name;
    private String password;
    private int poste_number;

    private int[] fallowing;

    private int[] fallower;
    private String[] bio;
    private Poste[] poste;
    int bio_count;

    private int fallowing_number;
    private int fallower_number;

    public int getPoste_number() {
        return poste_number;
    }

    public void setPoste_number(int poste_number) {
        this.poste_number = poste_number;
    }

    public int getFallowing_number() {
        return fallowing_number;
    }

    public void setFallowing_number(int fallowing_number) {
        this.fallowing_number = fallowing_number;
    }

    public int getFallower(int user) {
        return fallower[user];
    }

    public void setFallower(int i,int fallower) {
        this.fallower[i] = fallower;
    }

    public int getFallowing(int user) {
        return fallowing[user];
    }

    public void setFallowing(int i,int fallowing) {
        this.fallowing[i] = fallowing;
    }

    public int getFallower_number() {
        return fallower_number;
    }

    public void setFallower_number(int fallower_number) {
        this.fallower_number = fallower_number;
    }


    public String getBio(int word) {
        return bio[word];
    }

    public void setBio(String bio, int word) {
        this.bio[word] = bio;
    }


    public Poste[] getPoste() {
        return poste;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void creat_poste_object() {
        poste[poste_number] = new Poste();
    }

    User() {
        bio_count = 0;
        fallowing_number = 0;
        fallower_number = 0;
        bio = new String[10];
        poste = new Poste[100];
        fallowing = new int[100];
        fallower = new int[100];
    }

}
