package com.project

class Person {

    String firstName
    String lastName

    String getFullName() {
        firstName + " " + lastName
    }

    static constraints = {
    }
}
