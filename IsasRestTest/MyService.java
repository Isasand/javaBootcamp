package Mypackage;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path ("/MyService")
/**
 *
 * @author Isa
 */
public class MyService {
    @GET
    @Path("/hi")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHelloWorld(){
        return "Hello, welcome to my service";
    }
}
