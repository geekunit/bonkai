/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.resource;

import com.sun.jersey.api.view.Viewable;
import eu.codebits.bonkai.service.EntryService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author pmcosta
 */
@Stateless
@Path("/")
public class RootResource {
    
    @EJB
    private EntryService entryService;
    
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
    public Viewable translateView() 
    {
        
        return new Viewable("/translate", entryService.getTranslationBlock(null, null));
    }
    
    @Path("/review")
    @GET
    @Produces("text/html")
    public Viewable reviewView() 
    {
        
        return new Viewable("/review", entryService.getReviewBlock(null, null));
    }
    
    @Path("/search")
    @GET
    @Produces("text/html")
    public Viewable searchView() 
    {
        return new Viewable("/search", entryService.getSearchBlock());
    }
    
    
}
