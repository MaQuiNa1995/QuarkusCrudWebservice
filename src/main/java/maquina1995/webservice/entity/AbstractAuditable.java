package maquina1995.webservice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractAuditable<K extends Serializable> implements Persistible<K> {

	@CreationTimestamp
	protected LocalDateTime fechaCreacion;

	@UpdateTimestamp
	protected LocalDateTime fechaModificacion;

}
