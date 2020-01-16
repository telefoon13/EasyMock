package be.mikedhoore.Opgave1;

public class BookDAO {

    private IConnect connection;

    public BookDAO(IConnect connection) {
        this.connection = connection;
    }

    public boolean insert(Book book){
        return connection.insert(book);
    }

    public Book selectByID(Integer i){
        return connection.selectByID(i);
    }

}
