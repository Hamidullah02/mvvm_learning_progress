package com.learning.practice_nvvm_nav

import androidx.compose.ui.graphics.Color
import android.graphics.Color as Color1


// this is the model part of mvvm
//data source


class counterrepo {
    private var _counter = 0

    fun getcounter(): Int {
        return _counter
    }

    fun incremnt(): Int {
        _counter++
        return _counter
    }

    fun rset(): Int {
        _counter = 0
        return _counter
    }
}

data class SettingsModel(
    var selectedColorIndex: Int = 0,
    val colorOptions: List<Color> = listOf(
        Color.Black,
        Color.Red,
        Color.Green,
        Color.Blue,
        Color.Yellow,
        Color.Magenta
    )
)

class settingrepo {

    private var SettModelobject = SettingsModel()


    fun getselectedindex(): Int {
        return SettModelobject.selectedColorIndex
    }

    fun updatecolor(index: Int) {
        SettModelobject.selectedColorIndex
    }

    fun getcoloroptn(): List<Color> {
        return SettModelobject.colorOptions
    }
}

