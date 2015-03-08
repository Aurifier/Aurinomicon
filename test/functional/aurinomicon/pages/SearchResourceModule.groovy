package aurinomicon.pages

import geb.Module

class SearchResourceModule extends Module {
    static content = {
        resourceName {$("input", name: "search")}
        submit {$("button", text: "Search")}
    }

    void searchResource(String search) {
        resourceName.value(search)
        submit.click()
    }

    boolean hasResource(String resourceName) {
        js.hasResource(resourceName)
    }
}
