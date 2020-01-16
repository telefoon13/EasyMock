package be.mikedhoore.Opgave1;

public class Book {
    private Integer id;
    private String title;
    private String auteur;

    public Book() {
    }

    public Book(Integer id, String title, String auteur) {
        this.id = id;
        this.title = title;
        this.auteur = auteur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
