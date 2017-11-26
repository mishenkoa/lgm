package com.kuraleses.lgm.levels

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2
import com.kuraleses.lgm.shapes.Circle


public class LevelManager private constructor() {
    private object Holder { val INSTANCE = LevelManager() }

    companion object {
        val instance: LevelManager by lazy { Holder.INSTANCE }
    }

    var levels  : MutableList<Level> ? = mutableListOf<Level>()
    var current : Level ? = null

    fun loadLevel(number:Int) {
        //TODO dat shit
    }

    fun addLevel(level:Level) {
        levels?.add(level)
    }

    fun remove(number:Int) {
        //TODO dat shit
    }

    fun createFakeLevel() : Level {

        var circle = Circle(Vector2(100f, 100f), 50f, "#cccccc", ShapeRenderer.ShapeType.Filled)
        var circle2 = Circle(Vector2(234f, 228f), 50f, "#cccccc", ShapeRenderer.ShapeType.Filled)

        var level1 = Level(mutableListOf(circle, circle2), LevelState.IN_PROGRESS, 1)

        return level1
    }
}