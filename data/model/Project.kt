package com.example.portfolio.data.model

data class Project(
    val title: String,
    val description: String,
    val tech: List<String>,
    val link: String = ""
)
