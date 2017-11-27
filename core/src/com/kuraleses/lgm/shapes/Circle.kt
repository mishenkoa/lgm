package com.kuraleses.lgm.shapes

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.*
import com.kuraleses.lgm.Render
import com.kuraleses.lgm.World2d
import com.kuraleses.lgm.interfaces.Shape

class Circle(
        override var position: Vector2,
        val radius: Float,
        override var color: String,
        override var shapeType: ShapeRenderer.ShapeType
    ) : Shape {

    var body : Body

    init {
        val bodyDef = BodyDef()
        bodyDef.type = BodyDef.BodyType.KinematicBody
        bodyDef.position.set(position)
        body = World2d.i.world.createBody(bodyDef)

        val circleShape = CircleShape()
        circleShape.position.set(position)
        circleShape.radius = radius

        val fixtureDef = FixtureDef()
        fixtureDef.shape = circleShape
        fixtureDef.density = 1f

        body.createFixture(fixtureDef)
    }

    override fun render() {
        Render.i.renderer.begin(shapeType)
        Render.i.renderer.color = Color.valueOf(color)
        Render.i.renderer.circle(body.position.x, body.position.y, radius)
        Render.i.renderer.end()
    }
}