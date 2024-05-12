

public class Poste {


    private String[] text;
    private int like;

    private int commente_counte;
    private int[] like_person;
    private String[][] comment;
    private String[] comment_person;

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getLike_person(int i) {
        return like_person[i];
    }

    public void setLike_person(int like_person) {
        this.like_person[like] = like_person;
    }

    public String[][] getComment() {
        return comment;
    }

    public void setComment(String comment, int word) {
        this.comment[commente_counte][word] = comment;
    }

    public String[] getComment_person() {
        return comment_person;
    }

    public void setComment_person(String comment_person) {
        this.comment_person[commente_counte] = comment_person;
    }

    public String getText(int i) {
        return text[i];
    }

    public String[] getText_array() {
        return text;
    }

    public void setText(String text, int i) {
        this.text[i] = text;
    }


    public int getCommente_counte() {
        return commente_counte;
    }

    public void setCommente_counte(int commente_counte) {
        this.commente_counte = commente_counte;
    }

    Poste() {
        commente_counte = 0;
        text = new String[100];
        comment = new String[100][10];
        comment_person = new String[100];
        like_person = new int[100];
    }

}
