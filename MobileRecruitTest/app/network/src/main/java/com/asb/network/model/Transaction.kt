package com.asb.network.model

import android.os.Parcel
import android.os.Parcelable


data class Transaction(
    val id: String? = "",
    val transactionDate: String? = "",
    val summary: String? = "",
    val debit: Float = 0.0f,
    val credit: Float = 0.0f
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readFloat()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(transactionDate)
        parcel.writeString(summary)
        parcel.writeFloat(debit)
        parcel.writeFloat(credit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Transaction> {
        override fun createFromParcel(parcel: Parcel): Transaction {
            return Transaction(parcel)
        }

        override fun newArray(size: Int): Array<Transaction?> {
            return arrayOfNulls(size)
        }
    }
}