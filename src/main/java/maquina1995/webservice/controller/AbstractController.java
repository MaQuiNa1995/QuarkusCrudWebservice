package maquina1995.webservice.controller;

import java.io.Serializable;
import java.util.Optional;

import javax.ws.rs.core.Response;

import maquina1995.webservice.dto.AbstractDto;

public interface AbstractController<K extends Serializable, D extends AbstractDto<K>> {

	/**
	 * Endpoint que se encarga de la creacion de un {@link D}
	 * <p>
	 * Si va bien la operación devuelve un
	 * {@link javax.ws.rs.core.Response.Status#OK}
	 * 
	 * @param dto {@link D} representa el dto a crear
	 * 
	 * @return {@link Response}
	 */
	Response create(D dto);

	/**
	 * Endpoint que se encarga de la busqueda de un {@link D} por {@link K}
	 * <p>
	 * Si va bien la operación devuelve un
	 * {@link javax.ws.rs.core.Response.Status#OK}
	 * <p>
	 * Si al contrario no encuentra la entidad especificada por su ID {@link K}
	 * devuelve un {@link javax.ws.rs.core.Response.Status#NOT_FOUND}
	 * <p>
	 * 
	 * @see <b>Lecciones Aprendidas:</b> El parámetro del método debe tener el mismo
	 *      nombre que el que hayamos puesto en el path
	 * 
	 * @param id {@link Optional} de {@link K} que representa el pasado por
	 *           parámetro
	 * 
	 * @return {@link Response}
	 * 
	 */
	Response find(K id);

	/**
	 * Endpoint que se encarga de la busqueda de un {@link D} por {@link K}
	 * <p>
	 * Si la operación devuelve una lista vacía se devovlerá un
	 * {@link javax.ws.rs.core.Response.Status#NO_CONTENT}
	 * <p>
	 * Si al contrario no encuentra ninguna entidad devovlerá una lista vacía y el
	 * estado {@link Status#NOT_FOUND}
	 * 
	 * 
	 * @return {@link Response}
	 * 
	 */
	Response findAll();

	/**
	 * Endpoint que se encarga de la actualización de una entidad de base de datos
	 * <p>
	 * Si va bien la operación devuelve un
	 * {@link javax.ws.rs.core.Response.Status#OK}
	 * <p>
	 * Si el la clave primaria {@link K} del {@link D} proporcionado no se encuentra
	 * en BD se devuelve un {@link javax.ws.rs.core.Response.Status#NOT_FOUND}
	 * 
	 * @param dto {@link D} representa el dto a crear
	 * 
	 * @return {@link Response}
	 * 
	 */
	Response update(D dto);

	/**
	 * Endpoint que se encarga de la busqueda y eliminación de un {@link D} por
	 * {@link K}
	 * <p>
	 * Si va bien la operación devuelve un
	 * {@link javax.ws.rs.core.Response.Status#NO_CONTENT}
	 * <p>
	 * Si la operación no encuentra el recursos a borrar se devolverá un
	 * {@link javax.ws.rs.core.Response.Status#NOT_FOUND}
	 * 
	 * @param id {@link K} representa el id pasado por parámetro
	 * 
	 * @return {@link Response}
	 * 
	 */
	Response delete(K id);

}