package maquina1995.webservice.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import maquina1995.webservice.dto.AbstractDto;
import maquina1995.webservice.dto.DtoWrapper;
import maquina1995.webservice.service.AbstractService;

/**
 * @param <K> clave primaria de la entidad
 * @param <D> dto
 */
public abstract class AbstractControllerImpl<K extends Serializable, D extends AbstractDto<K>>
        implements AbstractController<K, D> {

	@Inject
	protected AbstractService<K, D> service;

	@POST
	@Override
	public Response create(D dto) {
		K id = service.create(dto);

		return Response.accepted(id)
		        .build();
	}

	@GET
	@Override
	@Path("/{id}")
	public Response find(@PathParam(value = "id") K id) {

		Optional<D> dto = service.find(id);

		return dto.isEmpty() ? Response.noContent()
		        .build()
		        : Response.ok(dto)
		                .build();
	}

	@GET
	@Override
	public Response findAll() {

		List<D> dtos = service.findAll();

		return dtos.isEmpty() ? Response.noContent()
		        .build()
		        : Response.ok(new DtoWrapper<>(dtos))
		                .build();
	}

	@PATCH
	@Override
	public Response update(D dto) {

		return this.buildResponse(service.update(dto))
		        .build();
	}

	@DELETE
	@Override
	public Response delete(K id) {

		return this.buildResponse(service.delete(id))
		        .build();
	}

	private ResponseBuilder buildResponse(boolean condition) {
		return condition ? Response.noContent() : Response.status(Status.NOT_FOUND);
	}

}
