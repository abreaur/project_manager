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

        def validationErrors = ""

        if (params.name != null && !params.name.isEmpty()){
            newProject.name = params.name
        } else {
            validationErrors += "Project name cannot be empty! "
        }

        if (params.code != null && !params.code.isEmpty()){
            newProject.code = params.code
        } else {
            validationErrors += "Project code cannot be empty! "
        }

        if (params.long('techLead.id') != null){
            newProject.techLead = Person.get(params.long('techLead.id'))
        } else {
            validationErrors += "Project tech lead cannot be empty! "
        }

        if (params.long('projectManager.id') != null){
            newProject.projectManager = Person.get(params.long('projectManager.id'))
        } else {
            validationErrors += "Project manager cannot be empty\n"
        }

        newProject.deliveryDate = new Date().parse("d/M/yyyy", params.deliveryDate_day + "/" + params.deliveryDate_month + "/" + params.deliveryDate_year).toTimestamp()

        if (params.status.id != null){
            newProject.status = Status.get(params.long('status.id'))
        } else {
            validationErrors += "Project status cannot be empty! "
        }

        if (params.int("priority") != null){
            newProject.priority = params.int("priority")
        } else {
            validationErrors += "Project priority cannot be empty! "
        }

        if (validationErrors.size() == 0 && newProject.save(failOnError: true, flush: true)) {
            // if ok, render the project list with success message
            flash.message = "Successfully saved project: " + newProject.name
            redirect(action: index())
        } else {
            // on failure, render failure message on the same view
            flash.error = "Error saving project " + newProject.name + ": " + validationErrors
            if (newProject.id != null) {
                redirect(action: 'edit', params: [id: newProject.id])
            } else {
                redirect(action: 'add')
            }

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
