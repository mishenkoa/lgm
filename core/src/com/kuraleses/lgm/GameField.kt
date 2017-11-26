package com.kuraleses.lgm

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2
import com.kuraleses.lgm.shapes.Circle

class GameField : ApplicationAdapter() {
    lateinit var renderer : ShapeRenderer
    lateinit var circle : Circle

    override fun create() {
        renderer = ShapeRenderer()
        circle = Circle(Vector2(50f, 50f), 50f,
                "#cccccc", ShapeRenderer.ShapeType.Filled)
    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        circle.render(renderer)
    }

    override fun dispose() {
        renderer.dispose()
    }
}
