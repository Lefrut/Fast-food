package com.dashkevich.fast_food.screens.bottom.screens

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.dashkevich.fast_food.data.repository.APIRepository
import com.dashkevich.fast_food.screens.bottom.screens.model.MainModel
import com.dashkevich.fast_food.util.resultHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val apiRepository: APIRepository) : BaseViewModel<MainModel>() {
    override fun setModel(): MainModel = MainModel()

    init {
        getPersonRequest()
    }

    private fun getPersonRequest(){
        viewModelScope.launch(Dispatchers.IO) {
            apiRepository.getPersons().resultHandler(
                onSuccess = {
                    setState {
                        copy(personRequest = it, ready = true)
                    }
                    Log.e("FragmentDebug", "success - $it")
                },
                onError = {
                    Log.e("FragmentDebug", "error - $it")
                },
                onEmptyResult = {
                    Log.e("FragmentDebug", "empty - $it")
                }
            )
        }
    }
}