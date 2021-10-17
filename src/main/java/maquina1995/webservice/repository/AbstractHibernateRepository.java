package maquina1995.webservice.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import maquina1995.webservice.entity.AbstractAuditable;

@Transactional
public abstract class AbstractHibernateRepository<K extends Serializable, E extends AbstractAuditable<K>> {

	@Inject
	protected EntityManager entityManager;

	public void persist(E entity) {
		entityManager.persist(entity);
	}

	public Optional<E> findById(K id) {

		Class<E> clazz = this.getArgumentTypeFromClass(1);
		return Optional.ofNullable(entityManager.find(clazz, id));
	}

	public List<E> findAll() {

		Class<E> clazz = this.getArgumentTypeFromClass(1);

		CriteriaQuery<E> criteriaQuery = entityManager.getCriteriaBuilder()
		        .createQuery(clazz);
		Root<E> entity = criteriaQuery.from(clazz);
		criteriaQuery.select(entity);

		return entityManager.createQuery(criteriaQuery)
		        .getResultList();
	}

	public void update(E entity) {
		entityManager.merge(entity);
	}

	public void delete(E entity) {
		entityManager.remove(entity);
	}

	private Class<E> getArgumentTypeFromClass(int index) {
		return (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[index];
	}

}
