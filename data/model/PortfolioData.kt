package com.example.portfolio.data.model

data class Skill(val name: String)

data class Contact(
    val type: String,
    val value: String,
    val icon: String
)

data class PortfolioUiState(
    val name: String = "Madhu Patel",
    val role: String = "Android Developer",
    val tagline: String = "Kotlin • MVVM • Material 3",
    val about: String = "Web apps, AI bots and Android tools — each one built end-to-end, from idea to deployment.",
    val skills: List<Skill> = emptyList(),
    val projects: List<Project> = emptyList(),
    val contacts: List<Contact> = emptyList()
)
