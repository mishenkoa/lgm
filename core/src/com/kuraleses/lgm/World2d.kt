package com.kuraleses.lgm

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.World

class World2d {
    private object Holder {
        val INSTANCE = World2d()
    }

    companion object {
        val i: World2d by lazy { Holder.INSTANCE }
    }

    private val stepConfig = object {
        val timeStep = 1f / 5.0f
        val velocityIterations = 8
        val positionIterations = 3
    }

    private val worldConfig = object {
        val gravity = Vector2(0f, -0.98f)
        val doSleep = true
    }

    val world = World(worldConfig.gravity, worldConfig.doSleep)

    fun step() {
        world.step(stepConfig.timeStep, stepConfig.velocityIterations,
                stepConfig.positionIterations)
    }
}