package com.buddyevents.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.buddyevents.node.entity.Person;

@RepositoryRestResource( collectionResourceRel ="people" ,path = "people")
public interface PersonRepository extends GraphRepository<Person>   {


    List<Person> findByName(@Param("name") String name);

}
