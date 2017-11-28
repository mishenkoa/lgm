package com.kuraleses.lgm.handlers

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.viewport.ExtendViewport

class Camera {
    private object Holder { val INSTANCE = Camera() }

    companion object {
        val i: Camera by lazy { Holder.INSTANCE }
    }

    val WORLD_WIDTH = 20.0f
    val WORLD_HEIGHT = 20.0f

    val viewport : ExtendViewport = ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT)
}