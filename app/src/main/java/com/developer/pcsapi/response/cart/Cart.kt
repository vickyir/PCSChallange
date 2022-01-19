package com.developer.pcsapi.response.cart

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cart (
        var id: Int,
        var harga: Int,
        var qty: Int
        ) : Parcelable