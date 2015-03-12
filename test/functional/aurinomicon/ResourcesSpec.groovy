package aurinomicon

import geb.spock.GebSpec
import aurinomicon.pages.MainPage

class ResourcesSpec extends GebSpec {
    def "adding a resource should save it in the database"() {
        given:
            def resourceName = "A test resource"
            to MainPage

        expect:
            at MainPage

        when:
            addResourceForm.addResource(resourceName)
            searchResourceForm.searchResource(resourceName)

        then:
            waitFor {
                searchResourceForm.hasResource(resourceName)
            }
    }

    def "if resources haven't been added they should not be in the database"() {
        given:
            to MainPage

        expect:
            at MainPage

        when:
            searchResourceForm.searchResource(resourceName)

        then:
            !searchResourceForm.hasResource(resourceName)

        where:
            resourceName << ["Unobtainium", "Baking Soda"]
    }

    def "added resources should persist through reloading the page"() {
        given:
            to MainPage

        expect:
            at MainPage

        when:
            addResourceForm.addResource(resourceName)
            to MainPage
            searchResourceForm.searchResource(resourceName)

        then:
            searchResourceForm.hasResource(resourceName)

        where:
            resourceName << ["Ash", "Ketchup"]
    }

    def "only resources matching the search string should be visible"() {
        given:
            def resourceName = "foofoo"
            def otherResourceName = "dumb stuff"
            to MainPage

        expect:
            at MainPage

        when:
            addResourceForm.addResource(resourceName)
            addResourceForm.addResource(otherResourceName)
            searchResourceForm.searchResource(resourceName)

        then:
            searchResourceForm.hasResource(resourceName)
            !searchResourceForm.hasResource(otherResourceName)
    }
}
