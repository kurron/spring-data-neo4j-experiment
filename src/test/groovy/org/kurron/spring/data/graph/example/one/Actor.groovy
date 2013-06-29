package org.kurron.spring.data.graph.example.one

/**
 * Domain model.
 **/
class Actor {
    String id
    String name
    Set<Movie> filmography
}
