package com.andhikaihsansapplication.app.modules.swipekananthree.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String
data class SwipeKananThreeModel(
    var txtDetailInformat: String? =
        MyApp.getInstance().resources.getString(R.string.lbl_detail_informat)
)
