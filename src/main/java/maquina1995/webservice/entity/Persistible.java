package maquina1995.webservice.entity;

import java.io.Serializable;

/**
 * Se encarga de marcar una clase como candidata a poder ser persistida en base
 * de datos
 * <p>
 * Con solo implementar esta clase no te valdría ya que si ves
 * {@link maquina1995.generic.microservice.service.AbstractServiceImpl}
 * tambien requiere de que E extienda de {@link AbstractAuditable}
 * 
 * @param <K> Tipo del objeto que es la clave primaria de una entidad de base de
 *            datos que implementa esta clase
 * 
 * @see {@link AbstractAuditable}
 * @see {@link maquina1995.generic.microservice.service.AbstractService}
 * @see {@link maquina1995.generic.microservice.service.AbstractServiceImpl}
 */
public interface Persistible<K extends Serializable> {

	/**
	 * Obtiene la clave primaria {@link K}
	 * <p>
	 * Por como está hecho el proyecto este se daría cuando te has olvidado de
	 * añadir la vlace primaria llamada <code>id</code> a la entidad no hace falta
	 * hacer la implementación ya que esta se generaría con lombok
	 * 
	 * @return {@link K} clae primaria de la entidad
	 */
	K getId();

	/**
	 * Setea la clave primaria {@link K}
	 * <p>
	 * Por como está hecho el proyecto este se daría cuando te has olvidado de
	 * añadir la clave primaria llamada <code>id</code> a la entidad no hace falta
	 * hacer la implementación ya que esta se generaría con lombok
	 * 
	 * @param id {@link K} clave primaria a setear de la entidad
	 */
	void setId(K id);

}
