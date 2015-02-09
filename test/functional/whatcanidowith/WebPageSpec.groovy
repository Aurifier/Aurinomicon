package whatcanidowith

import geb.spock.GebSpec
import spock.lang.Ignore
import whatcanidowith.pages.GooglePage
import whatcanidowith.pages.MainPage

class WebPageSpec extends GebSpec {
    def "page has the correct title"() {
        given:
            to MainPage
        expect:
            at MainPage
    }

    @Ignore
    def "adding a result should save it in the database"() {
        given:
            to MainPage

        expect:
            at MainPage

        when:
            addResource.resourceName.value("")

        then:
            assert 1
    }
}
