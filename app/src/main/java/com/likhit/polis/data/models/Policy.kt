package com.likhit.polis.data.models

import com.google.gson.annotations.SerializedName

import java.io.Serializable

class Policy : Serializable {

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("description")
    var detail: String? = null

    @SerializedName("image")
    var image: String? = null

    constructor() {}

    constructor(id: Int?, name: String, detail: String, image: String) {
        this.id = id
        this.name = name
        this.detail = detail
        this.image = image
    }
}
