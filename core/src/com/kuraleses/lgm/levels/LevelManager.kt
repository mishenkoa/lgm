package com.kuraleses.lgm.levels

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef
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
        var circle = Circle(Vector2(1f, 2f), 0.5f, "#cccccc", ShapeRenderer.ShapeType.Filled, BodyDef.BodyType.DynamicBody)
        var circle2 = Circle(Vector2(2.34f, 2.28f), 0.5f, "#cccccc", ShapeRenderer.ShapeType.Filled, BodyDef.BodyType.DynamicBody)
        var rect = Rect(Vector2(3f, 3f), 0.5f, 0.5f,"#cccccc", ShapeRenderer.ShapeType.Filled, BodyDef.BodyType.DynamicBody)
        var rect2 = Rect(Vector2(0f, 0f), 8f, 0.2f,"#cccccc", ShapeRenderer.ShapeType.Filled, BodyDef.BodyType.StaticBody)
        var level1 = Level(mutableListOf(circle, circle2, rect, rect2), LevelState.IN_PROGRESS, 1)
        return level1
    }

    // yes. this is pcuk.
    fun createPcuk() : Level {
        val rightBall = Circle(Vector2(200f, 100f), 100f, "#ffe0bd", ShapeRenderer.ShapeType.Filled, BodyDef.BodyType.StaticBody)
        val leftBall = Circle(Vector2(300f, 100f), 100f, "#ffe0bd", ShapeRenderer.ShapeType.Filled, BodyDef.BodyType.StaticBody)
        val tail = Rect(Vector2(200f, 50f), 100f, 300f,"#ffe0bd", ShapeRenderer.ShapeType.Filled, BodyDef.BodyType.StaticBody)
        val head = Circle(Vector2(250f, 350f), 75f, "#ffe0bd", ShapeRenderer.ShapeType.Filled, BodyDef.BodyType.StaticBody)
        return Level(mutableListOf(rightBall, leftBall, head, tail), LevelState.IN_PROGRESS, 1)
    }
}