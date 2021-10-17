package maquina1995.webservice.repository;

import javax.enterprise.context.ApplicationScoped;

import maquina1995.webservice.entity.Plant;

@ApplicationScoped
public class PlantRepository extends AbstractHibernateRepository<Long, Plant> {

}
