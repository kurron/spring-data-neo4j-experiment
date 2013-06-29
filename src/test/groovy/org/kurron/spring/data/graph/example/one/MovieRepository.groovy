package org.kurron.spring.data.graph.example.one

import org.springframework.data.neo4j.repository.GraphRepository

/**
 * Movie repository operations.
 */
public interface MovieRepository extends GraphRepository<Movie> {

}