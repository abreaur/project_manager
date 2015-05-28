package com.project

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Project)
class ProjectSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "constraints"() {
        setup:
        mockForConstraintsTests(Project)

        when:
        def status = new Status(description: "Briefing")
        def person = new Person(firstName: "Max", lastName: "Hackerson")
        def project = new Project(name: "some project", code: "1235",
                deliveryDate: new Date().parse("d/M/yyyy", "27/8/2015"),
                techLead: person, projectManager: person, status: status)

        project.priority = priority
        project.validate()

        then:
        project.hasErrors() == !valid

        where:

        priority | valid
        -1 | false // Must be greater than 0
        1 | true
    }
}
