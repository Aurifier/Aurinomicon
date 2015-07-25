package aurinomicon

import spock.lang.Ignore
import geb.spock.GebSpec
import aurinomicon.pages.MainPage

class ReactionsSpec extends GebSpec {
    def "adding a reaction should save it in the database"() {
        given:
            def resourceA = "Sin"
            def resourceB = "Death"
            def reactionName = "gives birth to"
            to MainPage

        expect:
            at MainPage

        when:
            addResourceForm.addResource(resourceA)
            addResourceForm.addResource(resourceB)
            addReactionForm.addReaction(reactionName, resourceA, resourceB)
            searchResourceForm.searchResource(resourceA)

        then:
            waitFor {
                searchResourceForm.hasResource(resourceA)
                searchResourceForm.hasResource(resourceB)
                searchResourceForm.hasReaction(resourceA, resourceB)
            }
    }

    def "a reaction that doesn't exist shouldn't appear when searched for"() {
        given:
            def resource = "NOLiNKSONMe"
            def otherResource = "something else"
            def reactionName = "solution"
            to MainPage

        expect:
            at MainPage

        when:
            addResourceForm.addResource(resource)
            searchResourceForm.searchResource(resource)

        then:
            waitFor {
                searchResourceForm.hasResource(resource)
                !searchResourceForm.hasReaction(resource, otherResource)
            }
    }

    def "a reaction is the link between two resources, not just their presence"() {
        given:
            def resourceA = "mn"
            def resourceB = "womn"
            to MainPage

        expect:
            at MainPage

        when:
            addResourceForm.addResource(resourceA)
            addResourceForm.addResource(resourceB)
            searchResourceForm.searchResource(resourceA)
            searchResourceForm.searchResource(resourceB)

        then:
            waitFor {
                searchResourceForm.hasResource(resourceA)
                searchResourceForm.hasResource(resourceB)
                !searchResourceForm.hasReaction(resourceA, resourceB)
            }
    }

    def "added reactions should persist through reloading the page"() {
        given:
            def resourceA = "stuff"
            def resourceB = "more stuff"
            def reactionName = "pyrolysis"
            to MainPage

        expect:
            at MainPage

        when:
            addResourceForm.addResource(resourceA)
            addResourceForm.addResource(resourceB)
            addReactionForm.addReaction(reactionName, resourceA, resourceB)
            to MainPage
            searchResourceForm.searchResource(resourceA)

        then:
            waitFor {
                searchResourceForm.hasResource(resourceA)
                searchResourceForm.hasResource(resourceB)
                searchResourceForm.hasReaction(resourceA, resourceB)
            }
    }
}
