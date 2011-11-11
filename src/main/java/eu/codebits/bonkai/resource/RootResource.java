/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.resource;

import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import eu.codebits.bonkai.model.Document;
import eu.codebits.bonkai.model.Entry;
import eu.codebits.bonkai.model.EntrySet;
import eu.codebits.bonkai.model.Subtitle;
import eu.codebits.bonkai.model.SubtitleEntry;
import eu.codebits.bonkai.service.EntryService;
import eu.codebits.bonkai.subripparser.Caption;
import eu.codebits.bonkai.subripparser.SubRipParser;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author pmcosta
 */
@Stateless
@Path("/")
public class RootResource {
    
    @EJB
    private EntryService entryService;
    
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String uploadDocument(@FormDataParam("language") String locale,
                                 @FormDataParam("file") InputStream in,
                                 @FormDataParam("file") FormDataContentDisposition fileInfo) throws IOException, ParseException {
        SubRipParser srp = new SubRipParser(in);
        List<Caption> captionList = srp.parse();
        List<EntrySet> entrySetList = new ArrayList<EntrySet>();
        EntrySet entrySet = null;
        if(locale.equals("en")) {
            entrySet = new EntrySet(Locale.ENGLISH);
        } else {
            entrySet = new EntrySet(new Locale("pt","PT"));
        }
        List<Entry> entryList = new ArrayList();
        for(Caption c : captionList) {
            StringBuilder stringBuilder = new StringBuilder();
            for(String line : c.getText()) {
                stringBuilder.append(line);
                stringBuilder.append(" ");
            }
            entryList.add(new SubtitleEntry(c.getNumber(), stringBuilder.toString(), c.getTimecodes()));
        }
        entrySet.setEntries(entryList);
        entrySetList.add(entrySet);
        Document document = new Subtitle(fileInfo.getFileName());
        
        document.setEntrySets(entrySetList);
        return entryService.createDocument(document);
    }
    
    @GET
    @Consumes({"text/plain,text/html"})
    @Produces("text/plain")
    public String getDescription() throws InstantiationException, NamingException {
        return "Bonkai Services";
    }
    
     ////// admin
    @Path("/index.html")
    @GET
    @Produces("text/html")
    public Viewable adminView() {
        return new Viewable("/index", "sadadasda");
    }
    
    
    @Path("/translate")
    @GET
    @Produces("text/html")
    public Viewable translateView() {
        return new Viewable("/translate", entryService.getTranslationBlock(null, null));
    }
    
    @Path("/review/{id}")
    @GET
    @Produces("text/html")
    public Viewable reviewView(
        @PathParam("id") Integer id) {
        System.out.println("ID!!!!!!! "+id);
        Map<String,Object> model = new HashMap();
        model.put("tilte", "This is the page title");
        model.put("reviewBlock", entryService.getReviewBlock(null, null));
        return new Viewable("/review", model);
    }
    
    
}
