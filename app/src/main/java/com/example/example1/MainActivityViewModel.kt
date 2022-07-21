package com.example.example1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.core.component.KoinComponent
import kotlin.random.Random

class MainActivityViewModel : ViewModel(), KoinComponent {

    val repository = ServerRepository(ServerApi.create())

    val insult = MutableLiveData<DTOInsult>()

    fun getInsult() {
        repository.getInsult("ru", Random.nextInt())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ _insult ->
                insult.postValue(_insult)
            }, {

            })
    }

}