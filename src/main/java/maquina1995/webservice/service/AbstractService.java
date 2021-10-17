package maquina1995.webservice.service;

import java.util.List;
import java.util.Optional;

import maquina1995.webservice.dto.AbstractDto;

/**
 * @param <K> Clave primaria
 * @param <D> Dto
 */
public interface AbstractService<K, D extends AbstractDto<?>> {

	/**
	 * Creación de un {@link D}
	 * 
	 * @param dto
	 * @return {@link D}
	 */
	K create(D dto);

	/**
	 * Obtencion de un {@link D} a traves de su clave primaria {@link K}
	 * 
	 * @param id clave primaria {@link K}
	 * 
	 * @return {@link Optional} de {@link D} con la presencia o no de la entidad
	 *         convertida a dto
	 * 
	 */
	Optional<D> find(K id);

	/**
	 * Obtención de todos los {@link D}
	 * 
	 * @return {@link List} de {@link D} en caso de no encontrar nada devuelve una
	 *         instancia vacía de una {@link List}
	 */
	List<D> findAll();

	/**
	 * 
	 * 
	 * @param dto {@link D} con los datos a modificar y con la clave primaria
	 *            {@link K} de la entidad a atacar
	 * 
	 */
	boolean update(D dto);

	/**
	 * 
	 * @param id clave primaria {@link K}
	 * @return booleano con el éxito en la eliminación
	 */
	boolean delete(K id);

}