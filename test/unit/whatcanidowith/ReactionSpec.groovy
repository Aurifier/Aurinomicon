package whatcanidowith

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Reaction)
class ReactionSpec extends Specification {

    void "test Reaction has a name"() {
        when:
        def reaction = new Reaction()

        then:
        !reaction.validate()


        when:
        reaction = new Reaction(name: "stuff")

        then:
        reaction.validate()
    }
}
