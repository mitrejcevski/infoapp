package nl.jovmit.infoapp.guides

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import nl.jovmit.infoapp.extensions.retrofit

fun createGuidesViewModel(activity: AppCompatActivity): GuidesViewModel {
    val repository = GuidesRemoteRepository(guidesApi())
    val factory = GuidesViewModelFactory(repository)
    return ViewModelProviders.of(activity, factory).get(GuidesViewModel::class.java)
}

fun guidesApi(): GuidesApi =
        retrofit.create(GuidesApi::class.java)