package org.kurron.spring.data.graph.example.one

import org.springframework.data.neo4j.annotation.Query
import org.springframework.data.neo4j.repository.GraphRepository

/**
 * Movie repository operations.
 */
public interface MovieRepository extends GraphRepository<Movie> {

    // a custom query method
    Movie getMovieById( String id )

    @Query( 'start user=node:User({0}) match user-[r:RATED]->movie return movie order by r.stars desc limit 10' )
    Iterable<Movie> getTopRatedMovies( User user )
}