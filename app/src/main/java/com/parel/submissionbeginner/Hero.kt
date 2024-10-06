package com.parel.submissionbeginner
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.Year

@Parcelize
data class Hero(
    val name: String,
    val description: String,
    val photo: Int,
    val genre: String,
    val year: String,
    val developer: String
) : Parcelable