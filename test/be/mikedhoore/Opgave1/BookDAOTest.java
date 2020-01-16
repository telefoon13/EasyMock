package be.mikedhoore.Opgave1;

import org.junit.*;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class BookDAOTest {

    private Book book;
    private BookDAO bookDAO;
    private IConnect mockedObject;

    @Before
    public void setUp() throws Exception {
        book = new Book();
        mockedObject = createMock(IConnect.class);
        bookDAO = new BookDAO(mockedObject);
    }

    @Test
    public void insert() {
        expect(mockedObject.insert(book)).andReturn(true);
        replay(mockedObject);
        assertTrue(bookDAO.insert(book));
        verify(mockedObject);
    }

    @Test
    public void selectByID() {
        Integer integer = 5;
        expect(mockedObject.selectByID(5)).andReturn(book);
        replay(mockedObject);
        assertEquals(book,bookDAO.selectByID(5));
        verify(mockedObject);
    }

}