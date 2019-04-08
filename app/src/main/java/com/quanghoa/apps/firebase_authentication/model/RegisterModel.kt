package com.quanghoa.apps.firebase_authentication.model

import com.quanghoa.apps.firebase_authentication.common.arePasswordsSame
import com.quanghoa.apps.firebase_authentication.common.isEmailValid
import com.quanghoa.apps.firebase_authentication.common.isUsernameValid

data class RegisterRequest(var name: String = "",
                           var email: String = "",
                           var password: String = "",
                           var repeatPassword: String = "") {
    fun isValid(): Boolean = isUsernameValid(name)
            && isEmailValid(email)
            && arePasswordsSame(password, repeatPassword)
}