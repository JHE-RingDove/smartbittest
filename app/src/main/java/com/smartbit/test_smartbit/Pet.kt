package com.smartbit.test_smartbit

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
@JsonIgnoreProperties
data class Pet (
    @JsonProperty("id")
    val id: Long? = 0,
    @JsonProperty("name")
    val name: String? = "NAME",
    @JsonProperty("status")
    val status: String? = "status",
    @JsonProperty("category")
    val category: List<Category>?,
    @JsonProperty("tags")
    val tags: List<Tag>?) {

    public data class Category(
        @JsonProperty("id")
        val id: Int? = 0,
        @JsonProperty("name")
        val name: String? = "name")
    public data class Tag(
        @JsonProperty("id")
        val id: Int? = 0,
        @JsonProperty("name")
        val name: String? = "name")
}
