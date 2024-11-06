package com.learning.practice_nvvm_nav

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


//this is the view-model
//gets data from model and processes then for view
// middle man of view and view-model

class CounterViewModel() : ViewModel() {
    private val _repo: counterrepo by lazy {
        try {
            counterrepo()
        } catch (e: Exception) {
            throw IllegalStateException("Failed to initialize repository", e)
        }
    }
    private val _counter = mutableStateOf(_repo.getcounter())
    val counter: State<Int> = _counter
    fun incrementCounter() {
        _counter.value = _repo.incremnt()
    }

    fun resetCounter() {
        _counter.value = _repo.rset()
    }
}


class settingviewmodel() : ViewModel() {
    private val _settrepo: settingrepo by lazy {
        try {
            settingrepo()
        } catch (e: Exception) {
            throw IllegalStateException("Failed to initialize repository", e)
        }
    }

    var selectedindex = mutableStateOf(_settrepo.getselectedindex())
    val coloptn = _settrepo.getcoloroptn()

    fun uodatecolor(index: Int) {
        selectedindex.value = index
        _settrepo.updatecolor(index)
    }
}