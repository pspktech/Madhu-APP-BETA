package com.example.portfolio.data.model

data class Project(
    val title: String,
    val description: String,
    val tech: List<String>,
    val link: String
)

data class Skill(val name: String)

data class Contact(
    val type: String,
    val value: String,
    val icon: String
)

data class PortfolioUiState(
    val name: String = "Your Name",
    val role: String = "Android Developer",
    val tagline: String = "Kotlin • MVVM • Material 3",
    val about: String = "Passionate Android developer building clean, scalable apps with modern architecture and beautiful UI.",
    val skills: List<Skill> = emptyList(),
    val projects: List<Project> = emptyList(),
    val contacts: List<Contact> = emptyList()
)
