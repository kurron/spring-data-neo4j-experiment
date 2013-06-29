package org.kurron.spring.data.graph.example.one

import org.neo4j.graphdb.RelationshipType

/**
 * Enumeration of relationships.
 **/
enum RelationshipTypes implements RelationshipType {
    ACTS_IN
}