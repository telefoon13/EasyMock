package be.mikedhoore.Opgave1;

public interface IConnect {
    boolean insert(Book book);
    Book selectByID(Integer i);
    boolean open();
    boolean close();
}
