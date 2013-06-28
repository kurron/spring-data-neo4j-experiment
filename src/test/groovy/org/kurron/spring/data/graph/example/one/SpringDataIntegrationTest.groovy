package org.kurron.spring.data.graph.example.one

import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Simple integration test to showcase a simple Neo4J interaction.
 */
@ContextConfiguration( locations = ['classpath:/org/kurron/spring/data/graph/example/one/SpringDataIntegrationTest-context.xml'] )
class SpringDataIntegrationTest extends Specification {
    void 'exercise neo4j'( ) {
        given: 'valid database instance'
        //assert template != null

        when: 'database is used'

        then: 'we should see data'
        true

        cleanup: 'close the database'
    }
}
