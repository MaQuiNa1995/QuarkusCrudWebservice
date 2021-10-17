package maquina1995.webservice.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import maquina1995.webservice.dto.AbstractDto;
import maquina1995.webservice.entity.AbstractAuditable;
import maquina1995.webservice.mapper.AbstractMapper;
import maquina1995.webservice.repository.AbstractHibernateRepository;

/**
 * 
 * @param <K> Clave primaria de la entidad y del Dto
 * @param <E> Entidad
 * @param <D> Dto
 */
public abstract class AbstractServiceImpl<K extends Serializable,
        E extends AbstractAuditable<K>,
        D extends AbstractDto<K>> implements AbstractService<K, D> {

	@Inject
	protected AbstractHibernateRepository<K, E> repository;
	@Inject
	protected AbstractMapper<E, D> mapper;

	@Override
	public K create(D dto) {

		E entity = mapper.dtoToEntity(dto);
		repository.persist(entity);

		return entity.getId();
	}

	@Override
	public Optional<D> find(K id) {

		return repository.findById(id)
		        .map(mapper::entityToDto);

	}

	@Override
	public List<D> findAll() {

		return repository.findAll()
		        .stream()
		        .map(mapper::entityToDto)
		        .collect(Collectors.toList());
	}

	@Override
	public boolean update(D dto) {

		boolean updated = false;

		E entity = mapper.dtoToEntity(dto);
		Optional<E> optionalEntity = repository.findById(entity.getId());

		if (optionalEntity.isPresent()) {
			entity.setId(optionalEntity.get()
			        .getId());
			repository.update(entity);
			updated = true;
		}
		return updated;
	}

	@Override
	public boolean delete(K id) {

		boolean deleted = false;
		Optional<E> optionalEntity = repository.findById(id);
		if (optionalEntity.isPresent()) {
			repository.delete(optionalEntity.get());
			deleted = true;
		}
		return deleted;
	}
}