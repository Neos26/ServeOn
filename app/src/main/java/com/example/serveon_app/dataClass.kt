package com.example.serveon_app

import android.os.Parcel
import android.os.Parcelable

data class dataClass(var dataImage: Int, var dataTitle: String, var dataDesc: String, var dataDetailImage: Int):
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataImage)
        parcel.writeString(dataTitle)
        parcel.writeString(dataDesc)
        parcel.writeInt(dataDetailImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<dataClass> {
        override fun createFromParcel(parcel: Parcel): dataClass {
            return dataClass(parcel)
        }

        override fun newArray(size: Int): Array<dataClass?> {
            return arrayOfNulls(size)
        }
    }
}
