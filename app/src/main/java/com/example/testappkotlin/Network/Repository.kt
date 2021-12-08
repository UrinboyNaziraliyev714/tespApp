package com.example.testappkotlin.Network

import androidx.lifecycle.MutableLiveData
import com.example.testappkotlin.Models.DataModel
import com.example.testappkotlin.Models.DataObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class Repository {
    val compositeDisposable = CompositeDisposable()
    fun getDataInfo(
        error: MutableLiveData<String>,
        success: MutableLiveData<List<DataObject>>
    ) {
        compositeDisposable.add(
            RetrofitInstance.getRetrofitInstance().getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<DataModel<List<DataObject>>>(){
                    override fun onNext(t: DataModel<List<DataObject>>) {
                            success.value = t.data
                    }
                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage
                    }

                    override fun onComplete() {

                    }

                })
        )
    }

}