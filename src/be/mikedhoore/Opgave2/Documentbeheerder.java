package be.mikedhoore.Opgave2;

import java.util.HashSet;
import java.util.Set;

public class Documentbeheerder {

    private Set<Document> documents = new HashSet<Document>();
    private Set<IMedewerker> medewerkers = new HashSet<IMedewerker>();

    public boolean addMedwerker(IMedewerker medewerker){
       return medewerkers.add(medewerker);
    }

    public void addDocument(Document document){
        boolean contains = documents.contains(document);
        documents.add(document);
        if (contains){
            documentChangedMessage(document);
        } else {
            documentAddedMessage(document);
        }
    }

    public boolean removeDocument(Document document){
        if (!documents.contains(document) || !voteForRemoval(document)) {
            return false;
        } else {
            documents.remove(document);
            documentremovedMessage(document);
            return true;
        }
    }

    /*public Document findByFileName(String documentName){
        Document document = documents.contains(documentName).;
    }*/

    private void documentAddedMessage(Document document){
        for (IMedewerker medewerker : medewerkers){
            medewerker.documentAdded(document);
        }
    }

    private void documentChangedMessage(Document document){
        for (IMedewerker medewerker : medewerkers){
            medewerker.documentChanged(document);
        }
    }

    private void documentremovedMessage(Document document){
        for (IMedewerker medewerker : medewerkers){
            medewerker.documentRemoved(document);
        }
    }

    private boolean voteForRemoval(Document document){
        boolean result = false;
        for (IMedewerker medewerker : medewerkers){
            result = medewerker.voteForRemoval(document);
        }
        return result;
    }
}
