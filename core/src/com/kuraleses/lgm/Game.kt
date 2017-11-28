package com.kuraleses.lgm

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.kuraleses.lgm.handlers.Camera
import com.kuraleses.lgm.handlers.Render
import com.kuraleses.lgm.handlers.World2d
import com.kuraleses.lgm.levels.Level
import com.kuraleses.lgm.levels.LevelManager

class Game : ApplicationAdapter() {
    lateinit var lvl : Level

    override fun create() {
        lvl = LevelManager.i.createFakeLevel()
        LevelManager.i.addLevel(lvl)
        LevelManager.i.current = lvl
    }

    override fun render() {
        Gdx.gl.glClearColor(255f, 255f, 255f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        Camera.i.viewport.apply()
//        println(Gdx.graphics.framesPerSecond)
        Render.i.renderer.projectionMatrix = Camera.i.viewport.camera.combined
//        Light.i.render()
        LevelManager.i.current?.objects?.forEach { it.render() }
        World2d.i.step()
    }

    override fun resize(width: Int, height: Int) {
        Camera.i.viewport.update(width, height, true)
    }

    override fun dispose() {
        Render.i.renderer.dispose()
        World2d.i.world.dispose()
//        Light.i.rayHandler.dispose()
    }
}
