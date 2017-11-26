package com.kuraleses.lgm.levels

import com.kuraleses.lgm.interfaces.Shape


class Level(
        var objects : MutableList<Shape>,
        var state   : LevelState,
        var number  : Int)