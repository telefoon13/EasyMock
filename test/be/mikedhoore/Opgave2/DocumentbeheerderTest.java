package be.mikedhoore.Opgave2;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class DocumentbeheerderTest {

    private Documentbeheerder documentbeheerder;
    private Document document;
    private IMedewerker fakeMedewerker;

    @Before
    public void setUp() throws Exception {
        documentbeheerder = new Documentbeheerder();
        document = new Document("Bestand.txt","/root/test/");
        fakeMedewerker = createMock(IMedewerker.class);
        documentbeheerder.addMedwerker(fakeMedewerker);
    }

    @Test
    public void testCase1(){
        replay(fakeMedewerker);
        assertFalse(documentbeheerder.removeDocument(document));
    }

    @Test
    public void testCase2() {
        fakeMedewerker.documentAdded(document);
        replay(fakeMedewerker);
        documentbeheerder.addDocument(document);
        verify(fakeMedewerker);
    }

    @Test
    public void testCase3(){
        fakeMedewerker.documentAdded(document);
        fakeMedewerker.documentChanged(document);
        expectLastCall().times(3);
        replay(fakeMedewerker);
        documentbeheerder.addDocument(document);
        documentbeheerder.addDocument(document);
        documentbeheerder.addDocument(document);
        documentbeheerder.addDocument(document);
        verify(fakeMedewerker);
    }

    @Test
    public void testCase4() {
        fakeMedewerker.documentAdded(document);
        expect(fakeMedewerker.voteForRemoval(document)).andReturn(true);
        fakeMedewerker.documentRemoved(document);
        replay(fakeMedewerker);
        documentbeheerder.addDocument(document);
        assertTrue(documentbeheerder.removeDocument(document));
        verify(fakeMedewerker);
    }

    @Test
    public void testCase5() {
        fakeMedewerker.documentAdded(document);
        expect(fakeMedewerker.voteForRemoval(document)).andReturn(false);
        replay(fakeMedewerker);
        documentbeheerder.addDocument(document);
        assertFalse(documentbeheerder.removeDocument(document));
        verify(fakeMedewerker);
    }
}