package com.kuraleses.lgm.interfaces

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2

interface Shape : Renderable, RigidBody {
    var shapeType: ShapeRenderer.ShapeType
    var position: Vector2
    var color: String
}