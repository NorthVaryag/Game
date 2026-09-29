package com.example.game

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    val array = listOf<String>("123", "456", "789")
    var secret: String = ""
    val displayWord = MutableLiveData("")
    val tryCount = MutableLiveData(0)
    var userInput = ""


    fun startGame() {
        secret = array.random().uppercase()
        tryCount.value = 6
        userInput = ""
        displayWord.value = viewDisplayWord()
    }

    fun viewDisplayWord(): String {
        var result = ""
        secret.forEach {
            if (userInput.contains(it))
                result += it
            else
                result += "_"
        }
        return result
    }

    fun userGuess(userString: String) {
        if (userString.length != 1)
            return
        val char = userString[0].uppercase()
        if (secret.contains(char))
        {
            userInput += char
            displayWord.value = viewDisplayWord()
        }
        else
        {
            tryCount.value = tryCount.value?.minus(1)
        }
    }

    fun isWin() : Boolean{
        return displayWord.value == secret
    }

    fun isLost() : Boolean{
        return tryCount.value!! <= 0
    }

    init {
        startGame()
    }
}