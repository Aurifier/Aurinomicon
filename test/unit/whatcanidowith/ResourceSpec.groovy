package whatcanidowith

import grails.test.mixin.TestFor
import spock.lang.Ignore
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Resource)
class ResourceSpec extends Specification {

    void "resource with no name does not validate"() {
        when:
            def resource = new Resource()

        then:
            !resource.validate()
    }
}
