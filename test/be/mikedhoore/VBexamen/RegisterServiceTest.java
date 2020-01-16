package be.mikedhoore.VBexamen;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class RegisterServiceTest {

    private User user;
    private RegisterService registerService;
    private IUserDAO mockUserDAO;

    @Before
    public void setUp() throws Exception {
        mockUserDAO = createMock(IUserDAO.class);
        registerService = new RegisterService(mockUserDAO);
    }

    @Test
    public void registerOK() throws PasswordException, UserException {
        user = new User();
        user.setGebruikersnaam("telefoon13");
        user.setNaam("Mike");
        user.setPaswoord("pass");
        user.setUserID(1);

        expect(mockUserDAO.storeUser("telefoon13","Mike","pass")).andReturn(user);
        replay(mockUserDAO);
        assertEquals(1,registerService.register("telefoon13","Mike","pass"));
        verify(mockUserDAO);
    }

    @Test
    public void registerFail() throws PasswordException, UserException {
        expect(mockUserDAO.storeUser("fail","fail","fail")).andReturn(null);
        replay(mockUserDAO);
        assertEquals(-1,registerService.register("fail","fail","fail"));
        verify(mockUserDAO);
    }

    @Test
    public void registerFailEmptyUserName() throws PasswordException, UserException {
        expect(mockUserDAO.storeUser("", "fail2","fail2")).andThrow(new UserException());
        replay(mockUserDAO);
        try {
            registerService.register("", "fail2","fail2");
            fail();
        } catch (UserException ex){
            assertEquals("Detected an empty string!", ex.getMessage());
        }

    }

    @Test(expected = PasswordException.class)
    public void registerFailEmptyPassword() throws PasswordException, UserException {
        expect(mockUserDAO.storeUser("fail3", "fail3","")).andThrow(new PasswordException());
        replay(mockUserDAO);
        registerService.register("fail3", "fail3","");
    }
}