package maquina1995.webservice;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/plant")
public class PlantController {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String create() {
		return "";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get() {
		return "";
	}

	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	public String update() {
		return "";
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String delete() {
		return "";
	}
}