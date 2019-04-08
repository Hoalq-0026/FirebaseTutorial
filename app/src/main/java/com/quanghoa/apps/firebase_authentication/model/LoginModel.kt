package com.quanghoa.apps.firebase_authentication.model

import com.quanghoa.apps.firebase_authentication.common.isEmailValid
import com.quanghoa.apps.firebase_authentication.common.isPasswordValid

data class LoginRequest(var email: String = "",
                        var password: String = "") {
    fun isValid() = isEmailValid(email) && isPasswordValid(password)
}