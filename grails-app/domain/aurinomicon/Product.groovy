package aurinomicon

class Product {
    Reaction reaction
    Resource resource
    Integer coefficient

    static constraints = {
        reaction nullable: false
        resource nullable: false
        coefficient min: 1
    }
}
