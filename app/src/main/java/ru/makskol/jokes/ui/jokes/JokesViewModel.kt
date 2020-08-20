package ru.makskol.jokes.ui.jokes

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.makskol.jokes.pojo.Joke
import ru.makskol.jokes.api.ApiFactory


class JokesViewModel : ViewModel() {

    private lateinit var jokesViewModel: JokesViewModel
    private val compositeDisposable = CompositeDisposable()
    val jokes: MutableLiveData<List<Joke>> = MutableLiveData()

    fun loadJokes(count:String) {

        val disposable = ApiFactory.apiService.getJokes(count)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                jokes.value = it?.value

            }, {

                Log.d("load_data", it.message)

            })

        compositeDisposable.add(disposable)

    }

    fun updateJokes() {

        jokes.value?.filter { true }

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}