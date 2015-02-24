package whatcanidowith.pages

import geb.Module

class AddResourceModule extends Module {
    static content = {
        resourceName {$("input", name: "resourceName")}
        submit {$("button", text: "Add Resource")}
    }

    void addResource(String addMe) {
        resourceName.value(addMe)
        submit.click()
    }
}
