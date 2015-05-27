package com.project

class ProjectController {

    def index() {
        render view: "index", model:  [projects: Project.list(sort: "priority", order: "asc")]
    }

    def view() {
        render view: "view", model: [project: Project.get(params.id), techLeads: Person.list(), managers: Person.list(), statuses: Status.list()]
    }

    def edit() {
        render view: "edit", model: [project: Project.get(params.id), techLeads: Person.list(), managers: Person.list(), statuses: Status.list()]
    }

    def add() {
        Project newProject = new Project()
        render view: "edit", model: [project: newProject, techLeads: Person.list(), managers: Person.list(), statuses: Status.list()]
    }

    def save() {
        def newProject = params.long('id') != null ? Project.get(params.long('id')) : new Project()

        newProject.setName(params.name)
        newProject.setCode(params.code)
        newProject.setTechLead(Person.get(params.long('techLead.id')))
        newProject.setProjectManager(Person.get(params.long('projectManager.id')))
        newProject.setDeliveryDate(new Date().parse("d/M/yyyy", params.deliveryDate_day + "/" + params.deliveryDate_month + "/" + params.deliveryDate_year).toTimestamp())
        newProject.setStatus(Status.get(params.long('status.id')))
        newProject.setPriority(params.int("priority"))

        if (newProject.save(failOnError: true, flush: true)) {
            // if ok, render the project list with success message
            flash.message = "Successfully saved project: " + newProject.name
            redirect(action: index())
        } else {
            // on failure, render failure message on the same view
            flash.error = "Error saving project " + newProject.name + ": " + newProject.errors
            redirect(action: index())
        }
    }

    def goToDelete() {
        render view: "delete", model: [id: params.id, name: params.name]
    }

    def delete() {
        def project =  Project.get(params.long('id'))
        String name = project.name
        project.delete(failOnError: true, flush: true)
        flash.message = "Successfully deleted project: " + name
        redirect(action: index())
    }
}
