package whatcanidowith

import geb.spock.GebSpec
import spock.lang.Ignore
import whatcanidowith.pages.MainPage

//TODO: DRY up some of these test pairs
class ResourcesSpec extends GebSpec {
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

    def "if a resource has not been added should not be in the database"() {
        given:
            def resourceName = "Unobtainium"
            to MainPage

        expect:
            at MainPage

        when:
            searchResourceForm.searchResource(resourceName)

        then:
            !searchResourceForm.hasResource(resourceName)
    }

    def "if another resource hasn't been added it shouldn't be in the database either"() {
        given:
            def resourceName = "Baking Soda"
            to MainPage

        expect:
            at MainPage

        when:
            searchResourceForm.searchResource(resourceName)

        then:
            !searchResourceForm.hasResource(resourceName)
    }

    def "an added resource should persist through reloading the page"() {
        given:
            def resourceName = "Ash"
            to MainPage

        expect:
            at MainPage

        when:
            addResourceForm.addResource(resourceName)
            to MainPage
            searchResourceForm.searchResource(resourceName)

        then:
            searchResourceForm.hasResource(resourceName)
    }

    def "some other added resources should also persist"() {
        given:
            def resourceName = "Ketchup"
            to MainPage

        expect:
            at MainPage

        when:
            addResourceForm.addResource(resourceName)
            to MainPage
            searchResourceForm.searchResource(resourceName)

        then:
            searchResourceForm.hasResource(resourceName)
    }
}
