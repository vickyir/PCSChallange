package com.developer.pcsapi

import com.developer.pcsapi.response.cart.Cart

interface CallbackInterface {
    fun passResultCallback(total:String, cart: ArrayList<Cart>)
}