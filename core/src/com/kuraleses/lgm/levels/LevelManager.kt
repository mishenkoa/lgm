package com.kuraleses.lgm.levels

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.World
import com.kuraleses.lgm.shapes.Circle
import com.kuraleses.lgm.shapes.Rect

public class LevelManager private constructor() {
    private object Holder { val INSTANCE = LevelManager() }

    companion object {
        val i: LevelManager by lazy { Holder.INSTANCE }
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
        var rect = Rect(Vector2(300f, 300f), 50f, 50f,"#cccccc", ShapeRenderer.ShapeType.Filled)
        var rect2 = Rect(Vector2(0f, 0f), 600f, 50f,"#cccccc", ShapeRenderer.ShapeType.Filled)
        var level1 = Level(mutableListOf(circle, circle2, rect, rect2), LevelState.IN_PROGRESS, 1)
        return level1
    }

    // yes. this is pcuk.
    fun createPcuk() : Level {
        val rightBall = Circle(Vector2(200f, 100f), 100f, "#ffe0bd", ShapeRenderer.ShapeType.Filled)
        val leftBall = Circle(Vector2(300f, 100f), 100f, "#ffe0bd", ShapeRenderer.ShapeType.Filled)
        val tail = Rect(Vector2(200f, 50f), 100f, 300f,"#ffe0bd", ShapeRenderer.ShapeType.Filled)
        val head = Circle(Vector2(250f, 350f), 75f, "#ffc0cb", ShapeRenderer.ShapeType.Filled)
        return Level(mutableListOf(rightBall, leftBall, head, tail), LevelState.IN_PROGRESS, 1)
    }
}