package com.example.marvelcharacters.listener

interface IListener<T> {
    fun onClick(item: T)
}