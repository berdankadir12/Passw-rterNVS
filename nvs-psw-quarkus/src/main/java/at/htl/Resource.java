package at.htl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("api/product/")

public class Resource {

    @Inject
    Repository repository;

    @POST
    @Path("newUser")
    public Response addNewUser(final User user) {

        if (user==null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        User newUser = repository.addNewUser(user);

        return Response.ok(newUser).build();
    }


}