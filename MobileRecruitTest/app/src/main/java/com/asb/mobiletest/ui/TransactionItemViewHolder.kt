package com.asb.mobiletest.ui

import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.plexure.theo.R

class TransactionItemViewHolder(val rootView: View) : RecyclerView.ViewHolder(rootView) {

    val tvOfferTime: TextView = rootView.findViewById(R.id.tv_card_offer_time)
    val tvOfferTitle: TextView = rootView.findViewById(R.id.tv_card_offer_title)
    val tvNormalPrice: TextView = rootView.findViewById(R.id.tv_card_normal_price)
    val tvSalePrice: TextView = rootView.findViewById(R.id.tv_card_sale_price)
    val ivThumbnail: ImageView = rootView.findViewById(R.id.iv_card_offer_thumbnail)

    var countDownTimer: CountDownTimer? = null

}
