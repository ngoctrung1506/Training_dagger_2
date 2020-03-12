package gooner.model

import javax.inject.Inject

class Screen @Inject constructor() {

    val name = "Dell 1189"
    val size = 22.5

    override fun toString(): String {
        return "Name is " + name + " with size is " + size + " inch"
    }
}