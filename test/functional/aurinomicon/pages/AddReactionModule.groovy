package aurinomicon.pages

import geb.Module

class AddReactionModule extends Module {
    static content = {
        reactionName {$("input", name: "reactionName")}
        resourceA {$("input", name: "resource1")}
        resourceB {$("input", name: "resource2")}
        submit {$("button", text: "Add Reaction")}
    }

    void addReaction(String name, String A, String B) {
        reactionName.value(name)
        resourceA.value(A)
        resourceB.value(B)
        submit.click()
    }
}
