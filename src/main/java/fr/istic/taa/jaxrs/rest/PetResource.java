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

import fr.istic.taa.jaxrs.dao.generic.DaoAppointment;
import fr.istic.taa.jaxrs.dao.generic.DaoUser;
import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.domain.appointment;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/user")
@Produces({"application/json", "application/xml"})
public class PetResource {

  @GET
  @Path("/{emailUser}")
  @Produces(MediaType.TEXT_PLAIN)
  public String ShowUserByMail(@PathParam("emailUser") String email)  {
	DaoUser user = new DaoUser();
	return user.showUser(user.getUserByMail(email));
      // return pet
  }

  
  @GET
  @Path("/voirtout")
  @Produces(MediaType.TEXT_PLAIN)
  public String ShowAll() {
	  DaoUser user = new DaoUser();
	  return user.showAllUser(user.getAllUser());
  }
  @GET
  @Path("/voirUser")
  @Produces(MediaType.APPLICATION_JSON)
  public List<User> GetAll() {
	  DaoUser user = new DaoUser();
	  return user.getAllUser();
  }
  
  @GET
  @Path("/get/{emailUser}")
  @Produces(MediaType.APPLICATION_JSON)
  public User GetMail(@PathParam("emailUser") String email)  {
	DaoUser user = new DaoUser();
	return user.getUserByMail(email);
      // return pet
  }
  
  @GET
  @Path("/rdv/{email}")
  @Produces(MediaType.APPLICATION_JSON)
  @JsonIgnore
  public appointment getRdv(@PathParam("email") String email) {
	  DaoUser user = new DaoUser();
	  DaoAppointment DaoApp = new DaoAppointment();
	  return DaoApp.getAppointment(user.getUserByMail(email));
  }
  
  @POST
  @Path("/test")
  @Consumes("application/json")
  public Response addPet(
      @Parameter(description = "Pet object that needs to be added to the store", required = true) Pet pet) {
    // add pet
    return Response.ok().entity("SUCCESS").build();
  }
  
  @POST
  @Path("/getuser/json")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  public String getuser(User u) {
	  System.out.println(u.getName());
	return "ok";
  }
  
  @POST
  @Path("/add/{name}/{email}/{pwd}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response AddUser(@PathParam("name") String name,@PathParam("email") String email, @PathParam("pwd") String pwd)  {
	DaoUser userDao = new DaoUser();
	userDao.createUser(name, email, pwd);
	return Response.ok().entity("SUCCESS").build();
      // return pet
  }
  
}