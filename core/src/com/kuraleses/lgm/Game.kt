package com.kuraleses.lgm

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.kuraleses.lgm.handlers.Render
import com.kuraleses.lgm.handlers.World2d
import com.kuraleses.lgm.levels.Level
import com.kuraleses.lgm.levels.LevelManager

class Game : ApplicationAdapter() {
    val WORLD_WIDTH = 10.0f
    val WORLD_HEIGHT = 10.0f

    lateinit var lvl : Level
    lateinit var viewport : ExtendViewport
    lateinit var spriteBatch : SpriteBatch
    lateinit var texture : Texture
    lateinit var sprite: Sprite

    override fun create() {
        lvl = LevelManager.i.createFakeLevel()
        LevelManager.i.addLevel(lvl)
        LevelManager.i.current = lvl
        viewport = ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT)

        texture = Texture(Gdx.files.internal("circle.png"), true)
        texture.setFilter(Texture.TextureFilter.MipMapLinearLinear, Texture.TextureFilter.MipMapLinearLinear)
        sprite = Sprite()
        spriteBatch = SpriteBatch()
        sprite.setRegion(texture)
    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        viewport.apply()
        spriteBatch.projectionMatrix = viewport.camera.combined
        spriteBatch.begin()
        spriteBatch.color = Color.valueOf("#cccccc")
        spriteBatch.draw(sprite, 4f, 4f, 1.28f, 1.28f)
        spriteBatch.end()
        // println(Gdx.graphics.framesPerSecond)
        World2d.i.step()
        Render.i.renderer.projectionMatrix = viewport.camera.combined
        LevelManager.i.current?.objects?.forEach { it.render() }
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun dispose() {
        Render.i.renderer.dispose()
        World2d.i.world.dispose()
    }
}
