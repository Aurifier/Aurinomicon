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
}
