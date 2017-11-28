package com.kuraleses.lgm.handlers

import com.badlogic.gdx.graphics.g2d.SpriteBatch

class Render {
    private object Holder { val INSTANCE = Render() }

    companion object {
        val i: Render by lazy { Holder.INSTANCE }
    }

    val renderer = SpriteBatch()
}