package nl.jovmit.infoapp.extensions

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData

fun <T> LiveData<T>.observe(owner: LifecycleOwner, block: (t: T) -> Unit) {
    this.observe(owner, android.arch.lifecycle.Observer<T> {
        it?.let(block)
    })
}