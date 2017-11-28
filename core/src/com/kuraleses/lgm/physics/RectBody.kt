package com.kuraleses.lgm.physics

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.*
import com.kuraleses.lgm.handlers.World2d

class RectBody(
        private val bodyType : BodyDef.BodyType,
        private val position : Vector2,
        private val width: Float,
        private val height: Float,
        private val density : Float = 1f,
        private val friction : Float = 1f,
        private val restitution : Float = 0f
        ) {

    fun get() : Body {
        val bodyDef = BodyDef()
        bodyDef.type = bodyType
        bodyDef.position.set(position)
        val body = World2d.i.world.createBody(bodyDef)

        val polyShape = PolygonShape()
        val centerOfRect = Vector2(width / 2, height / 2)
        polyShape.setAsBox(centerOfRect.x ,centerOfRect.y, Vector2(0f, 0f), bodyDef.angle)

        val fixtureDef = FixtureDef()
        fixtureDef.shape = polyShape
        fixtureDef.density = density // mass of a body, measured in kilograms by square meter
        fixtureDef.friction = friction // bodies slide [0..1]
        fixtureDef.restitution = restitution // determines how much a body will bounce after a collision

        body.createFixture(fixtureDef)
        return body
    }
}