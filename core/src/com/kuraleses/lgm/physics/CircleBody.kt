package com.kuraleses.lgm.physics

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.Body
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.CircleShape
import com.badlogic.gdx.physics.box2d.FixtureDef
import com.kuraleses.lgm.handlers.World2d

class CircleBody(
        private val bodyType : BodyDef.BodyType,
        private val position : Vector2,
        private val radius : Float,
        private val density : Float = 1f,
        private val friction : Float = 1f,
        private val restitution : Float = 0f
        ) {

    fun get() : Body {
        val bodyDef = BodyDef()
        bodyDef.type = bodyType
        bodyDef.position.set(position)
        val body = World2d.i.world.createBody(bodyDef)

        val circleShape = CircleShape()
        circleShape.position.set(position)
        circleShape.radius = radius

        val fixtureDef = FixtureDef()
        fixtureDef.shape = circleShape
        fixtureDef.density = density // mass of a body, measured in kilograms by square meter
        fixtureDef.friction = friction // bodies slide [0..1]
        fixtureDef.restitution = restitution // determines how much a body will bounce after a collision

        body.createFixture(fixtureDef)

        return body
    }
}