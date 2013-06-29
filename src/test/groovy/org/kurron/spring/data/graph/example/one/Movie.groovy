package org.kurron.spring.data.graph.example.one

import org.springframework.data.neo4j.annotation.GraphId
import org.springframework.data.neo4j.annotation.NodeEntity

/**
 * Domain model
 **/
@NodeEntity
class Movie {
    @GraphId Long nodeId
    String id
    String title
    int year
    Set<Role> cast
}
