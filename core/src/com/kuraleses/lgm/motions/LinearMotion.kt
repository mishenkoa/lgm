package com.kuraleses.lgm.motions

import com.badlogic.gdx.math.Vector2
import com.kuraleses.lgm.interfaces.Motion
import com.kuraleses.lgm.interfaces.Shape

class LinearMotion(
        override var shape: Shape,
        override var speed: Float,
        override var velocity: Vector2
    ) : Motion {
    override fun startMotion() {
    }

    override fun stopMotion() {
    }
}