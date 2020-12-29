package com.example.shoppingyuk.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipes(
    val title: String=" ",
    val thumb: String=" ",
    val times: String=" ",
    val key: String =" ",
    val portion: String =" ",
    val dificulty: String = " "
) : Parcelable
