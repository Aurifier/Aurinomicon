package aurinomicon

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Product)
@Mock([Reaction, Resource])
class ProductSpec extends Specification {

    void "test Product must have a Reaction and Resource"() {
        when: 'a Product is missing a Reaction and Resource'
        def product = new Product();

        then: 'the Product should not validate'
        !product.validate();


        when: 'a Product is missing a Reaction'
        product = new Product(resource: new Resource());

        then: 'the Product should not validate'
        !product.validate();


        when: 'a Product is missing a Resource'
        product = new Product(reaction: new Reaction());

        then: 'the Product should not validate'
        !product.validate();
    }

    void "test coefficient is at least one, if present"() {
        when:
        def product = new Product(resource: new Resource(), reaction: new Reaction(), coefficient: 0);

        then:
        !product.validate();
    }
}
