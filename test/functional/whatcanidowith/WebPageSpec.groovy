package whatcanidowith

import geb.spock.GebSpec
import whatcanidowith.pages.MainPage

class WebPageSpec extends GebSpec {
    def "page has the correct title"() {
        given:
            to MainPage
        expect:
            at MainPage
    }

    def "adding a resource should save it in the database"() {
        given:
            def resourceName = "A test resource"
            to MainPage

        expect:
            at MainPage

        when:
            addResourceForm.addResource(resourceName)

        then:
            waitFor{at MainPage}

        when:
            searchResourceForm.searchResource(resourceName)

        then:
            searchResourceForm.hasResource(resourceName)
    }
}
