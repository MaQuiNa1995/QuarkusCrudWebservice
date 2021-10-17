package maquina1995.webservice.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Objeto que embuelve una {@link List} de {@link D} para ser enviada desde los
 * microservicios de recursos
 * 
 * @param <D> Representa el Dto que tendrá la {@link List} de este objeto
 *            {@link DtoWrapper}
 */
@Getter
@Setter
@RequiredArgsConstructor
public class DtoWrapper<D extends AbstractDto<?>> implements Serializable {

	/**
	 * Representa la {@link List} de {@link D}
	 */
	private final List<D> dtos;

	/**
	 * Retorna una lista INMUTABLE {@link Arrays#asList(Object...)} de {@link D}
	 * 
	 * @param createdDto el objeto que tendrá la lista
	 */
	public DtoWrapper(D createdDto) {
		super();
		this.dtos = Arrays.asList(createdDto);
	}

	public DtoWrapper() {
		super();
		this.dtos = new ArrayList<>();
	}

}
