package com.example.serveon_app.DataClasses

import android.os.Parcel
import android.os.Parcelable

data class dataClass(var dataImage: Int, var dataTitle: String,var dataDesc: String, var namelist: String, var servicelist: String,
                     var contactlist: String, var ratinglist: String, var dataDetailImage: Int, var backGroundImage: Int):
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt()

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataImage)
        parcel.writeString(dataTitle)
        parcel.writeString(dataDesc)
        parcel.writeString(namelist)
        parcel.writeString(servicelist)
        parcel.writeString(contactlist)
        parcel.writeString(ratinglist)
        parcel.writeInt(dataDetailImage)
        parcel.writeInt(backGroundImage)
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
