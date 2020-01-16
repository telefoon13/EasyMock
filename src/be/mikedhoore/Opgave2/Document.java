package be.mikedhoore.Opgave2;

import java.util.Objects;

public class Document {

    private String title;
    private String path;

    public Document(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;
        Document document = (Document) o;
        return getTitle().equals(document.getTitle()) &&
                getPath().equals(document.getPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getPath());
    }
}
