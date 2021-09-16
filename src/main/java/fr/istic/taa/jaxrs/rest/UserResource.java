package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.istic.taa.jaxrs.dao.generic.RendezVousDAO;
import fr.istic.taa.jaxrs.dao.generic.UserDAO;
import fr.istic.taa.jaxrs.domain.RendezVous;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/user")
@Produces({"application/json", "application/xml"})
public class UserResource {

  @GET()
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/show/{mailUser}")
  public String showUserByMail(@PathParam("mailUser") String mail)  {
	  UserDAO u = new UserDAO();
      return u.showUser(u.getUserByMail(mail));
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/get/{mailUser}")
  @JsonIgnore
  public User getUserByMail(@PathParam("mailUser") String mail)  {
	  UserDAO u = new UserDAO();
      return u.getUserByMail(mail);
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getAll")
  @JsonIgnore
  public List<User> getAllUser()  {
	  UserDAO u = new UserDAO();
      return u.getAllUser();
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getRDV/{UserMail}")
  @JsonIgnore
  public RendezVous getRDVMail(@PathParam("UserMail") String mail)  {
	  RendezVousDAO r = new RendezVousDAO();
	  UserDAO u = new UserDAO();
      return r.getRdvByMail(u.getUserByMail(mail));
  }

  @POST
  @Consumes("application/json")
  public Response addPet(
      @Parameter(description = "Pet object that needs to be added to the store", required = true) User pet) {
    // add pet
    return Response.ok().entity("SUCCESS").build();
  }
}