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

    // a little stress test
    fun createFakeLevel() : Level {
        var circle = Circle(Vector2(300f, 600f), 60f, "#008744", BodyDef.BodyType.DynamicBody)
        var circle2 = Circle(Vector2(234f, 228f), 60f, "#0057e7", BodyDef.BodyType.DynamicBody)
        var rect = Rect(Vector2(1300f, 1300f), 150f, 150f,"#F60C86", BodyDef.BodyType.DynamicBody)
        var circle3 = Circle(Vector2(300f, 700f), 60f, "#008744", BodyDef.BodyType.DynamicBody)
        var circle4 = Circle(Vector2(234f, 328f), 60f, "#0057e7", BodyDef.BodyType.DynamicBody)
        var rect2 = Rect(Vector2(1300f, 1400f), 150f, 150f,"#F60C86", BodyDef.BodyType.DynamicBody)
        var circle5 = Circle(Vector2(300f, 800f), 60f, "#008744", BodyDef.BodyType.DynamicBody)
        var circle6 = Circle(Vector2(234f, 428f), 60f, "#0057e7", BodyDef.BodyType.DynamicBody)
        var rect3 = Rect(Vector2(1300f, 1500f), 150f, 150f,"#F60C86", BodyDef.BodyType.DynamicBody)
        var circle7 = Circle(Vector2(300f, 900f), 60f, "#008744", BodyDef.BodyType.DynamicBody)
        var circle8 = Circle(Vector2(234f, 528f), 60f, "#0057e7", BodyDef.BodyType.DynamicBody)
        var rect4 = Rect(Vector2(1300f, 1600f), 150f, 150f,"#F60C86", BodyDef.BodyType.DynamicBody)
        var rect5 = Rect(Vector2(1000f, 50f), 2500f, 100f,"#2E89BA", BodyDef.BodyType.StaticBody)
        var level1 = Level(mutableListOf(circle, circle2, rect, rect2, circle3, circle4, circle5, circle6, circle7, circle8, rect3, rect4, rect5), LevelState.IN_PROGRESS, 1)
        return level1
    }

    // yes. this is pcuk.
    fun createPcuk() : Level {
        val rightBall = Circle(Vector2(200f, 100f), 100f, "#ffe0bd", BodyDef.BodyType.StaticBody)
        val leftBall = Circle(Vector2(300f, 100f), 100f, "#ffe0bd", BodyDef.BodyType.StaticBody)
        val tail = Rect(Vector2(200f, 50f), 100f, 300f,"#ffe0bd", BodyDef.BodyType.StaticBody)
        val head = Circle(Vector2(250f, 350f), 75f, "#ffe0bd", BodyDef.BodyType.StaticBody)
        return Level(mutableListOf(rightBall, leftBall, head, tail), LevelState.IN_PROGRESS, 1)
    }
}