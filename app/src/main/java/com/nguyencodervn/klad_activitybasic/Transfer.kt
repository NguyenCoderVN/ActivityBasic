package com.nguyencodervn.klad_activitybasic

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

data class Transfer01 (
    val language : String,
    val api : Int,
) : Serializable


@Parcelize
data class Transfer02 (
    val language : String,
    val api : Int,
) : Parcelable