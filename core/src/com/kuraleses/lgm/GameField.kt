package com.kuraleses.lgm

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.kuraleses.lgm.levels.Level
import com.kuraleses.lgm.levels.LevelManager

class GameField : ApplicationAdapter() {
    lateinit var lvl : Level

    override fun create() {
        lvl = LevelManager.i.createFakeLevel()
        LevelManager.i.addLevel(lvl)
        LevelManager.i.current = lvl
    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        World2d.i.step()
        LevelManager.i.current?.objects?.forEach { it.render() }
    }

    override fun dispose() {
        Render.i.renderer.dispose()
        World2d.i.world.dispose()
    }
}
