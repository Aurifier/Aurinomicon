package aurinomicon

@grails.rest.Resource(uri = '/resources', formats = ['json', 'xml'])
class Resource {
    String name

    static constraints = {
        name nullable: false
    }
}
