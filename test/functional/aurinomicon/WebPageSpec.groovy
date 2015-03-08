package aurinomicon

import geb.spock.GebSpec
import aurinomicon.pages.MainPage

class WebPageSpec extends GebSpec {
    def "page has the correct title"() {
        given:
            to MainPage
        expect:
            at MainPage
    }
}
