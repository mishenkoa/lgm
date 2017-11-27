package com.kuraleses.lgm

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.kuraleses.lgm.levels.Level
import com.kuraleses.lgm.levels.LevelManager
import com.badlogic.gdx.utils.viewport.FitViewport



class GameField : ApplicationAdapter() {
    val WORLD_WIDTH = 1000.0f
    val WORLD_HEIGHT = 1000.0f

    lateinit var lvl : Level
    lateinit var viewport : ExtendViewport

    override fun create() {
        lvl = LevelManager.i.createFakeLevel()
        LevelManager.i.addLevel(lvl)
        LevelManager.i.current = lvl
        viewport = ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT)
    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        viewport.apply()
        Render.i.renderer.projectionMatrix = viewport.camera.combined;
        LevelManager.i.current?.objects?.forEach { it.render() }
        World2d.i.step()
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun dispose() {
        Render.i.renderer.dispose()
        World2d.i.world.dispose()
    }
}
