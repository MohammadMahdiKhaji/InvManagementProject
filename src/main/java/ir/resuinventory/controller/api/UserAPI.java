package ir.resuinventory.controller.api;

import ir.resuinventory.model.service.UserService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/userAPI")
public class UserAPI {

        //http://localhost:8080/api/userAPI/activeEmail/-166351310
        @GET
        @Path("/activeEmail/{code}")
        @Produces(MediaType.TEXT_HTML)
        public String activeUserEmail(@PathParam("code") String code) throws Exception {

            if (UserService.getUserService().activeUserEmail(code)) {
                return "<html><head><title>Active user email</title></head><body><h1>Hello, Email has been activated!</h1><p>This is a sample HTML page served by ResuInventory.</p></body></html>";
            }
            return "<html><head><title>Active user email</title></head><body><h1>Hello, Invalid URL!</h1><p>This is a sample HTML page served by ResuInventory.</p></body></html>";
        }
}
