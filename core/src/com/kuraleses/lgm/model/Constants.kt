package com.kuraleses.lgm.model

// TODO: REFACTOR THIS FUCKONG SHIT ASDKLN, ISPENT THREE HOURS TO FIX THE FUCKNG BUG
class Constants {
    private object Holder { val INSTANCE = Constants() }

    companion object {
        val i: Constants by lazy { Holder.INSTANCE }
    }

    // PPM == pixels per meter, 1m == 100px, it is necessary to convert into units of box2d
    val PPM: Float = 100f

    // put colors here, bitch
    val lightColor: String = "ffffff"
}