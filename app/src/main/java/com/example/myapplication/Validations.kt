package com.example.myapplication

class Validations {
    fun validateString(text: String):Boolean {
        if(text.trim() == "") { return false }

        return true
    }

    fun ValidateInteger(number: Int): Boolean {
        if(number <= 0){
            return false
        }

        return true
    }
}