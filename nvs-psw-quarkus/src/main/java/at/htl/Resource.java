package at.htl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;



@Path("api/product/")

public class Resource {

    @Inject
    Repository repository;

    @POST
    @Path("register")
    public Response addNewUser(final User user) {

        if (user==null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        HashingPassword hashingPassword = new HashingPassword();

        String newPassword = hashingPassword.hash(user.getPassword());

        user.setPassword(newPassword);
        user.setSalt(hashingPassword.getSalt2());

        User newUser = repository.addNewUser(user);


        return Response.ok(newUser).build();
    }
    @PATCH
    @Path("forgetPassword")
    public Response changePassword(final User user) {

        repository.entityManager.persist(user);
        return  Response.ok("Erfolgreich geändert").build();
    }

    @GET
    @Path("login")
    public Response getUserByUserName(User user1){
        User user = repository.findUserById(user1.getUsername(),user1.getPassword());

        if(user != null){
             return Response.ok("Erfolgreich eingeloggt").build();
        }
        else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }


}