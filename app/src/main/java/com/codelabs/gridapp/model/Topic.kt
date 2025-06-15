package com.codelabs.gridapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val idLabel: Int,
    val suscriptors: Int,
    @DrawableRes val idImage: Int
)
