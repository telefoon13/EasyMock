package be.mikedhoore.VBexamen;

public interface IUserDAO {
    public User storeUser(String gebruikersnaam, String naam, String paswoord) throws UserException,PasswordException;
}
