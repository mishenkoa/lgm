package com.kuraleses.lgm.shapes

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.*
import com.kuraleses.lgm.Render
import com.kuraleses.lgm.interfaces.RigidBody
import com.kuraleses.lgm.interfaces.Shape
import com.kuraleses.lgm.physics.CircleBody

class Circle(
        override var position: Vector2,
        val radius: Float,
        override var color: String,
        override var shapeType: ShapeRenderer.ShapeType,
        bodyType: BodyDef.BodyType,
        density : Float = 1f,
        friction : Float = 1f,
        restitution : Float = 0f
    ) : Shape, RigidBody {

    override var body : Body = CircleBody(bodyType, position, radius,
                        density, friction, restitution).get()

    override fun render() {
        Render.i.renderer.begin(shapeType)
        Render.i.renderer.color = Color.valueOf(color)
        Render.i.renderer.circle(body.position.x, body.position.y, radius)
        Render.i.renderer.end()
    }
}