/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.dao;
import eu.codebits.bonkai.model.Document;
import eu.codebits.bonkai.model.Entry;
import eu.codebits.bonkai.model.EntrySet;
import eu.codebits.bonkai.model.Subtitle;
import eu.codebits.bonkai.model.SubtitleEntry;
import eu.codebits.bonkai.subripparser.Caption;
import eu.codebits.bonkai.subripparser.SubRipParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author pmcosta
 */
@Startup
@Singleton
//@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class EntryDao {
    @PersistenceContext(unitName = "eu.codebits_bonkai_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @PostConstruct
    public void init() throws MalformedURLException, IOException, ParseException {}
    
    
    public EntrySet createEntrySetInDocument(Locale locale, Document document) {
    EntrySet entrySet = new EntrySet(locale);
    
   
    return entrySet;
    }
    
    
    public Document insertDocument(String name) {
        Document document = new Document(name);
        em.persist(document);
        return document;
    };

    public void insertDocument(Document document) {
       em.persist(document);
    }

    public Document getDocumentToTranslate(Locale sourceLanguage, Locale destinationLanguage) {
        
//        List<EntrySet> entrySetListIncomplete = em.createQuery("select e from EntrySet e where "
//                + " e.lang=:destinationLang and e.isComplete=false")
//                .setParameter("destinationLang", destinationLanguage)
//                .getResultList();
        
        List<Document> fuckingDocuments = em.createNativeQuery("select * from Document where id in (select document_id from EntrySet where document_id in (select document_id from EntrySet where isComplete='N' and lang='pt_PT') and isComplete='Y' and lang='en')",Document.class).getResultList();
        
        
//        List<Document> documentList = em.createQuery("select d from Document d inner join d.entrySets e where e IN :incomplete")
//                .setParameter("incomplete", entrySetListIncomplete)
//                .getResultList();;
//        
//        List<EntrySet> entrySetList = em.createQuery("select e from EntrySet e where e.document IN "
//                + " (select d from Document d join EntrySet e where e IN :incomplete) "
//                + " and e.lang=:sourceLang and e.isComplete=true")
//                .setParameter("incomplete", entrySetListIncomplete)
//                .setParameter("sourceLang", sourceLanguage)
//                .getResultList();
        
        for(Document d : fuckingDocuments) {
            System.out.println("!!!!!!!!!!!!!!!!!"+d.getName());
        }
        return null;
    }
    
    
}
