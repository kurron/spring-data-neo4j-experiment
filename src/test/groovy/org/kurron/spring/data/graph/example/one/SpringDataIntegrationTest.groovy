package org.kurron.spring.data.graph.example.one

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.neo4j.repository.GraphRepository
import org.springframework.data.neo4j.support.Neo4jTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.*
/**
 * Simple integration test to showcase a simple Neo4J interaction.
 */
@ContextConfiguration(locations = ['classpath:/org/kurron/spring/data/graph/example/one/SpringDataIntegrationTest-context.xml'])
class SpringDataIntegrationTest extends Specification {

    @Autowired Neo4jTemplate template
    @Autowired MovieRepository movieRepository

    @Transactional
    void 'exercise insert and retrieve'() {
        given: 'valid template'
        assert template != null

        when: 'database is used'
        Movie detached = new Movie()
        detached.id = 'bob'
        detached.title = 'Forrest Gump'
        detached.year = 1994
        Movie attached = template.save( detached )
        Movie fetched = template.findOne( attached.getNodeId(), Movie )

        then: 'we should see data'
        assertThat( attached.nodeId, is( equalTo( fetched.nodeId ) )  )
        assertThat( detached.title, is( equalTo( fetched.title ) )  )
        assertThat( detached.year, is( equalTo( fetched.year ) )  )

        cleanup: 'close the database'
    }

    @Transactional
    void 'exercise index operations'() {
        given: 'valid template'
        assert template != null

        when: 'database is used'
        Movie detached = new Movie()
        detached.id = 'uuid'
        detached.title = 'Forrest Gump'
        detached.year = 1994
        Movie attached = template.save( detached )
        GraphRepository<Movie> repository = template.repositoryFor( Movie )
        Movie fetched = repository.findByPropertyValue( 'id' , detached.id )

        then: 'we should see data'
        assertThat( attached.nodeId, is( equalTo( fetched.nodeId ) )  )
        assertThat( detached.title, is( equalTo( fetched.title ) )  )
        assertThat( detached.year, is( equalTo( fetched.year ) )  )

        cleanup: 'close the database'
    }

    @Transactional
    void 'exercise movie repository'() {
        given: 'valid repository'
        assert movieRepository != null

        when: 'database is used'
        Movie detached = new Movie()
        detached.id = 'uuid'
        detached.title = 'Forrest Gump'
        detached.year = 1994
        Movie attached = template.save( detached )
        Movie fetched = movieRepository.findByPropertyValue( 'id' , detached.id )

        then: 'we should see data'
        assertThat( attached.nodeId, is( equalTo( fetched.nodeId ) )  )
        assertThat( detached.title, is( equalTo( fetched.title ) )  )
        assertThat( detached.year, is( equalTo( fetched.year ) )  )

        cleanup: 'close the database'
    }
}
