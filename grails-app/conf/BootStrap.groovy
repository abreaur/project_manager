import com.project.Project
import com.project.Person
import com.project.Status

class BootStrap {

    def init = { servletContext ->

        // Status list
        Status briefing = new Status(description: "Briefing").save()
        Status scoping = new Status(description: "Scoping").save()
        Status interaction = new Status(description: "Interaction").save()
        Status development = new Status(description: "Development").save()
        Status qa = new Status(description: "QA").save()
        Status release = new Status(description: "Release").save()

        // Test data
        Person smith = new Person(firstName: "John", lastName: "Smith").save()
        Person doe = new Person(firstName: "Jane", lastName: "Doe").save()
        Person greenleaf = new Person(firstName: "Ben", lastName: "Greenleaf").save()
        Person max = new Person(firstName: "Max", lastName: "Hackerson").save()

        new Project(name: "BNP Paribas integration project", code: "1234", deliveryDate: new Date().parse("d/M/yyyy", "01/04/2016").toTimestamp(),
                priority: 2, techLead: max, projectManager: smith, status: interaction).save(failOnError: true)
        new Project(name: "Gantt chart project manangement plugin", code: "1235", deliveryDate: new Date().parse("d/M/yyyy", "27/8/2015").toTimestamp(),
                priority: 3, techLead: greenleaf, projectManager: doe, status: development).save(failOnError: true)
        new Project(name: "Business inteligence module", code: "2234", deliveryDate: new Date().parse("d/M/yyyy", "2/6/2015").toTimestamp(),
                priority: 1, techLead: max, projectManager: doe, status: qa).save(failOnError: true)
    }
    def destroy = {
    }
}
