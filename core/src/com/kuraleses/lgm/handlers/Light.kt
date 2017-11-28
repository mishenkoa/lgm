package com.kuraleses.lgm.handlers

import box2dLight.DirectionalLight
import box2dLight.RayHandler
import com.badlogic.gdx.graphics.Color
import com.kuraleses.lgm.interfaces.Renderable
import com.kuraleses.lgm.model.Constants

class Light : Renderable {
    private object Holder { val INSTANCE = Light() }

    companion object {
        val i: Light by lazy { Holder.INSTANCE }
    }

    object pLightConfig {
        val rays: Int = 500
        val color: Color = Color.valueOf(Constants.i.lightColor)
        val distance: Float = 50f
        val x: Float = -5f
        val y: Float = 10f
    }

    object dLightConfig {
        val rays: Int = 100
        val color: Color = Color.valueOf(Constants.i.lightColor)
        val dir: Float = 2f
    }

    val rayHandler = RayHandler(World2d.i.world)
    val lights = DirectionalLight(rayHandler, dLightConfig.rays, Color.CYAN, -90f)
//    val light = PointLight(rayHandler, pLightConfig.rays, pLightConfig.color,
//                           pLightConfig.distance, pLightConfig.x, pLightConfig.y)
//    val lig = ConeLight(rayHandler, 2048, Color.CYAN, 20f, 10f, 10f, -90f, 180f)
    init {
        // put here some config of rayHandler
//        rayHandler.setAmbientLight(Color.valueOf("#ffe0bd"))
        rayHandler.setShadows(true)
    }

    override fun render() {
        Light.i.rayHandler.setCombinedMatrix(Camera.i.viewport.camera.combined)
        Light.i.rayHandler.updateAndRender()
    }
}