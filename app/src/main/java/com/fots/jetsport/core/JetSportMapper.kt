package com.fots.jetsport.core

/**
 * @author: fevziomurtekin
 * @date: 24/04/2021
 */
interface JetSportMapper<E,R> {
    suspend operator fun invoke(input: E): R
    suspend operator fun invoke(
        input: R,
        isEntity: Boolean = true
    ): E
}