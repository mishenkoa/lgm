package com.kuraleses.lgm.interfaces

import com.badlogic.gdx.math.Vector2

interface Motion {
    var shape : Shape
    var velocity : Vector2
    var speed : Float

    fun startMotion()
    fun stopMotion()
}