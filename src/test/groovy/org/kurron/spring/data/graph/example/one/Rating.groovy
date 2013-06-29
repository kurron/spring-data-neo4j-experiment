package org.kurron.spring.data.graph.example.one

/**
 * Domain model.
 **/
class Rating {
    User user
    Movie movie
    int stars
    String comment
}
