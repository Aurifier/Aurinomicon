package aurinomicon.pages

import geb.Page

class MainPage extends Page {
    static url = "/Aurinomicon"
    static at = {title == "The Aurinomicon"}
    static content = {
        addResourceForm{module AddResourceModule}
        addReactionForm{module AddReactionModule}
        searchResourceForm{module SearchResourceModule}
    }
}
