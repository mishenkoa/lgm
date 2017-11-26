package com.kuraleses.lgm.shapes

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2
import com.kuraleses.lgm.interfaces.Shape

class Circle(
        override var position: Vector2,
        var radius: Float,
        override var color: String,
        override var shapeType: ShapeRenderer.ShapeType
    ) : Shape {
    override fun render(renderer: ShapeRenderer) {
        renderer.begin(shapeType)
        renderer.color = Color.valueOf(color)
        renderer.circle(position.x, position.y, radius)
        renderer.end()
    }

    override fun dispose(renderer: ShapeRenderer) {
        renderer.dispose()
    }
}