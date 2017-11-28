package com.kuraleses.lgm.handlers

class Constants {
    private object Holder { val INSTANCE = Constants() }

    companion object {
        val i: Constants by lazy { Holder.INSTANCE }
    }

    val PPM : Float = 100f;
}