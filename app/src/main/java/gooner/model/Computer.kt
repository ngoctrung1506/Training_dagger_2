package gooner.model

import javax.inject.Inject

class Computer @Inject constructor(val screen: Screen) {

    val mName: String = "Dell"
    val nColor: String = "Black"

    fun showScreenInfo() = screen.toString()
}