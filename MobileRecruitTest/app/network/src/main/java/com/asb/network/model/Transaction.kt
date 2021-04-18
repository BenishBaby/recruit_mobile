package com.asb.network.model

import android.os.Parcel
import android.os.Parcelable


data class Transaction(
    val id: String? = "",
    val transactionDate: String? = "",
    val summary: String? = "",
    val debit: Double = 0.0,
    val credit: Double = 0.0,
    val gst: Double = 0.0
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readDouble(),
            parcel.readDouble(),
            parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(transactionDate)
        parcel.writeString(summary)
        parcel.writeDouble(debit)
        parcel.writeDouble(credit)
        parcel.writeDouble(gst)
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