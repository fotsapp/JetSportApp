package com.fots.jetsport.data

/**
 * @author: fevziomurtekin
 * @date: 24/04/2021
 */

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    object Loading: Result<Nothing>()
    data class Error(val throwable: Throwable) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=${throwable.message}]"
            else -> "Loading"
        }
    }

}
