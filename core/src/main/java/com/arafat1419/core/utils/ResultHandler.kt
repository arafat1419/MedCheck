package com.arafat1419.core.utils

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.arafat1419.core.vo.ErrorData
import com.arafat1419.core.vo.Resource

class ResultHandler(
    private val isLoading: MutableLiveData<Boolean>
) {
    fun <T> handle(
        result: Resource<T>,
        onError: (ErrorData) -> Unit = {},
        onSuccess: (T) -> Unit,
    ) {
        when (result) {
            is Resource.Error -> {
                setLoading(false)
                Log.d("TAG", result.error?.message.toString())

                result.error?.let { onError(it) }
            }

            is Resource.Loading -> {
                setLoading(true)
                Log.d("TAG", "Loading..")
            }

            is Resource.Success -> {
                setLoading(false)
                Log.d("TAG", result.data.toString())

                if (result.data == null) return
                onSuccess(result.data)
            }
        }
    }

    private fun setLoading(state: Boolean) {
        isLoading.value = state
    }
}