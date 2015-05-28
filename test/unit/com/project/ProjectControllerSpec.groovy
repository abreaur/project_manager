package com.project

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ProjectController)
@Mock([Project, Status, Person])
class ProjectControllerSpec extends Specification {

    def setup() {

    }

    def cleanup() {
        Status.deleteAll(Status.list())
        Person.deleteAll(Person.list())
    }

    void 'index action'() {
        setup:
        Status status = new Status(description: "Briefing").save()
        Person person = new Person(firstName: "Max", lastName: "Hackerson").save()
        new Project(name: "some project", code: "1235",
                deliveryDate: new Date().parse("d/M/yyyy", "27/8/2015").toTimestamp(),
                techLead: person, projectManager: person, status: status, priority: 1).save()

        new Project(name: "second project", code: "asdasd",
                deliveryDate: new Date().parse("d/M/yyyy", "27/8/2015").toTimestamp(),
                techLead: person, projectManager: person, status: status, priority: 2).save()

        when:
        controller.index()

        then:
        view == '/project/index'
        model.projects.size == 2
    }


    void 'edit action'() {
        setup:
        Status status = new Status(description: "Briefing").save()
        Person person = new Person(firstName: "Max", lastName: "Hackerson").save()
        Project project = new Project(name: "some project", code: "1235",
                deliveryDate: new Date().parse("d/M/yyyy", "27/8/2015").toTimestamp(),
                techLead: person, projectManager: person, status: status, priority: 1).save()

        when:
        params.id = project.id
        controller.edit()

        then:
        view == '/project/edit'
        model.project.code == "1235"
    }
}
