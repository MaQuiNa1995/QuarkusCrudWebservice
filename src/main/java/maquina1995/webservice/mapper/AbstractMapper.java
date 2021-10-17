package maquina1995.webservice.mapper;

/**
 * Encargado de la transformación de tipos delegando la generación del mapper a
 * <code>MapStructs</code>
 *
 * @param <E> Entidad
 * @param <D> Dto
 */
public interface AbstractMapper<E, D> {

	/**
	 * Transforma un {@link E} a un {@link D}
	 * 
	 * @param entity {@link E} a ser transformada
	 * 
	 * @return {@link D} resultante
	 */
	D entityToDto(E entity);

	/**
	 * Transforma un {@link D} a un {@link E}
	 * 
	 * @param entity {@link D} a ser transformada
	 * 
	 * @return {@link E} resultante
	 */
	E dtoToEntity(D dto);

}
