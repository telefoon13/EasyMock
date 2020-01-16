package be.mikedhoore.VBexamen;

public class RegisterService implements IRegisterService {

    private IUserDAO userDAO;

    public RegisterService(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public int register(String gebruikersnaam, String naam, String paswoord) throws PasswordException, UserException {
        User user = userDAO.storeUser(gebruikersnaam, naam, paswoord);
        int id = -1;
        if (user != null){
            id = user.getUserID();
        }
        return id;
    }

}
