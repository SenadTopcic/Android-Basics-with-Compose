package com.example.a30daysapp.modal

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Quota(
        val id : Int,
    @StringRes val nameRes :Int,
    @StringRes val quotaRes :Int,
    @DrawableRes val profileImageRes :Int
)
