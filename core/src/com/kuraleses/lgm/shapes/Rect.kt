package com.kuraleses.lgm.shapes

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.MathUtils.radiansToDegrees
import com.badlogic.gdx.physics.box2d.*
import com.kuraleses.lgm.Render
import com.kuraleses.lgm.interfaces.Shape
import com.kuraleses.lgm.physics.RectBody

class Rect(
        override var position: Vector2,
        var width: Float, var height: Float,
        override var color: String,
        override var shapeType: ShapeRenderer.ShapeType,
        bodyType: BodyDef.BodyType,
        density : Float = 1f,
        friction : Float = 1f,
        restitution : Float = 0f
    ) : Shape {

    override var body : Body = RectBody(bodyType, position, width, height,
                        density, friction, restitution).get()

    override fun render() {
        Render.i.renderer.begin(shapeType)
        Render.i.renderer.color = Color.valueOf(color)
        Render.i.renderer.rect(body.position.x - width / 2, body.position.y - height / 2,
                width / 2, height / 2, width, height,
                1f, 1f, body.angle * radiansToDegrees)
        Render.i.renderer.end()
    }
}