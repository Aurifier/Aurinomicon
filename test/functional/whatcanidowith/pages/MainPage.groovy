package whatcanidowith.pages

import geb.Page

class MainPage extends Page {
    static url = "/WhatCanIDoWith"
    static at = {title == "What Can I Do With...?"}
    static content = {
        addResource{module AddResourceModule}
    }
}
