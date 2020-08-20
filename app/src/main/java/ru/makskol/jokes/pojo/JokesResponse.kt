package ru.makskol.jokes.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class JokesResponse {

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("value")
    @Expose
    var value: List<Joke>? = null

}