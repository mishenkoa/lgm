package com.kuraleses.lgm.shapes

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.MathUtils.radiansToDegrees
import com.badlogic.gdx.physics.box2d.*
import com.kuraleses.lgm.handlers.Render
import com.kuraleses.lgm.interfaces.Shape
import com.kuraleses.lgm.model.Constants
import com.kuraleses.lgm.physics.RectBody

class Rect(
        override var position: Vector2,
        var width: Float, var height: Float,
        override var color: String,
        bodyType: BodyDef.BodyType,
        density : Float = 1f,
        friction : Float = 1f,
        restitution : Float = 0f
    ) : Shape {

    private val rectConfig = object {
        val x : Float = position.x / Constants.i.PPM
        val y : Float = position.y / Constants.i.PPM
        val mWidth : Float = width / Constants.i.PPM
        val mHeight : Float = height / Constants.i.PPM
    }

    override var body : Body = RectBody(bodyType, Vector2(rectConfig.x, rectConfig.y), rectConfig.mWidth,
                        rectConfig.mHeight, density, friction, restitution).get()

    private var texture : Texture
    private var sprite: Sprite

    init {
        texture = Texture(Gdx.files.internal("textures/square.png"))
        sprite = Sprite(texture)
    }

    override fun render() {
        Render.i.renderer.begin()
        Render.i.renderer.color = Color.valueOf(color)
        Render.i.renderer.draw(sprite, body.position.x - rectConfig.mWidth / 2, body.position.y - rectConfig.mHeight / 2,
                rectConfig.mWidth / 2, rectConfig.mHeight / 2, rectConfig.mWidth, rectConfig.mHeight,
                1f, 1f, body.angle * radiansToDegrees)
        Render.i.renderer.end()
    }
}