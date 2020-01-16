package be.mikedhoore.Opgave2;

public interface IMedewerker {
    void documentAdded(Document document);
    void documentChanged(Document document);
    void documentRemoved(Document document);
    boolean voteForRemoval(Document document);
}
