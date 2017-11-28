package com.kuraleses.lgm.shapes

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureFilter.MipMapLinearLinear
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.*
import com.kuraleses.lgm.handlers.Render
import com.kuraleses.lgm.interfaces.Shape
import com.kuraleses.lgm.model.Constants
import com.kuraleses.lgm.physics.CircleBody

class Circle(
        override var position: Vector2,
        val radius: Float,
        override var color: String,
        bodyType: BodyDef.BodyType,
        density : Float = 1f,
        friction : Float = 1f,
        restitution : Float = 0f
    ) : Shape {

    private val MIPMAP_OFFSET = 2f / Constants.i.PPM // cuz the mipmapping cuts 4px on each side of the texture

    private val circleConfig = object {
        val x : Float = position.x / Constants.i.PPM
        val y : Float = position.y / Constants.i.PPM
        val mRadius : Float = radius  / Constants.i.PPM
    }

    override var body : Body = CircleBody(bodyType, Vector2(circleConfig.x, circleConfig.y),
                                circleConfig.mRadius - MIPMAP_OFFSET, density, friction, restitution).get()

    private var texture : Texture
    private var sprite: Sprite

    init {
        texture = Texture(Gdx.files.internal("textures/circle.png"), true)
        texture.setFilter(MipMapLinearLinear, MipMapLinearLinear)
        sprite = Sprite(texture)
    }

    override fun render() {
        Render.i.renderer.begin()
        Render.i.renderer.color = Color.valueOf(color)
        Render.i.renderer.draw(sprite, body.position.x - circleConfig.mRadius, body.position.y - circleConfig.mRadius,
                        circleConfig.mRadius * 2, circleConfig.mRadius * 2)
        Render.i.renderer.end()
    }
}