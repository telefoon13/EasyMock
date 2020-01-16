package be.mikedhoore.VBexamen;

public interface IRegisterService {
    public int register(String gebruikersnaam, String naam, String paswoord) throws PasswordException, UserException;
}
