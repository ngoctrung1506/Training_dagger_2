package gooner.demo.training_dagger

import gooner.model.User

inline class Name(val user: User) {

    val length: Int
        get() = user.name.length

    fun greet() {
        println("Hello, $user")
    }
}