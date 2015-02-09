package whatcanidowith.pages

import geb.Module

class AddResourceModule extends Module {
    static content = {
        resourceName {$("input", name: "resourceName")}
        submit(to: MainPage) {
            $("input", value: "Add Resource")
        }
    }
}
