package ru.makskol.jokes.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Joke(id: Int, text: String) {

    @SerializedName("id")
    @Expose
    val id: Int = 0
    @SerializedName("joke")
    @Expose
    val joke: String = ""

}