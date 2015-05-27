package com.project

class Project {

    String name
    String code
    Date deliveryDate
    int priority
    Person techLead
    Person projectManager
    Status status

    static belongsTo = [techLead : Person, projectManager: Person, status: Status]

    static constraints = {
        priority unique: true, min: 1
    }
}
