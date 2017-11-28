package com.kuraleses.lgm.handlers

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer
import com.badlogic.gdx.physics.box2d.World

class World2d {
    private object Holder {
        val INSTANCE = World2d()
    }

    companion object {
        val i: World2d by lazy { Holder.INSTANCE }
    }

    var accumulator: Float = 0f
    var delta: Float = 0f

    private val stepConfig = object {
        val timeStep = 1f / 60f
        val velocityIterations = 6
        val positionIterations = 2
    }

    private val worldConfig = object {
        val gravity = Vector2(0f, -9.81f)
        val doSleep = true
    }

    val world = World(worldConfig.gravity, worldConfig.doSleep)

//    var dbgRenderer = Box2DDebugRenderer() // debug physics renderer

    fun step() {
        delta = Gdx.graphics.deltaTime
        accumulator += Math.min(delta, 0.25f);

        while (accumulator >= stepConfig.timeStep) {
            accumulator -= stepConfig.timeStep
            world.step(stepConfig.timeStep, stepConfig.velocityIterations,
                    stepConfig.positionIterations)
        }
//        dbgRenderer.render(world, Render.i.renderer.projectionMatrix)
    }
}