package nl.jovmit.infoapp.extensions

import android.support.annotation.LayoutRes
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import nl.jovmit.infoapp.R

fun SwipeRefreshLayout.setupDefaultColorScheme() =
        this.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent)

fun ViewGroup.inflate(@LayoutRes layoutResource: Int): View =
        LayoutInflater.from(context).inflate(layoutResource, this, false)

fun ImageView.setImageUrl(imageUrl: String) {
    if (imageUrl.isNotBlank()) {
        Picasso.get().load(imageUrl).into(this)
    }
}