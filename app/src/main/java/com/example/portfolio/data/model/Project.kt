package com.madhupatel.portfolio.data.model

data class Project(
    val id: Int,
    val index: String,
    val title: String,
    val description: String,
    val category: String,
    val tags: List<String>, // ఇక్కడ List<String> ఉండాలి
    val isFeatured: Boolean = false,
    val isNew: Boolean = false,
    val detailsUrl: String? = null,
    val sourceUrl: String? = null,
    val liveUrl: String? = null,
    val apkUrl: String? = null,
    val telegramUrl: String? = null,
    val previewIcon: String,
    val previewStyle: String
)

object PortfolioProjects {
    val all: List<Project> = listOf( // ఇక్కడ List<Project> ఉండాలి
        Project(1, "01 — BOT", "WhatsApp AI Bot",
            "An AI-powered WhatsApp bot built on Node.js that automatically replies to incoming messages using an AI API.",
            "AI Automation", listOf("Node.js", "Express.js", "AI API", "WhatsApp Web"),
            detailsUrl = "projects/whatsapp-bot.html",
            sourceUrl = "https://github.com/pspktech/whatsapp-ai-bot",
            previewIcon = "whatsapp", previewStyle = "bot"),
        Project(2, "02 — WEBSITE", "Nandhu Pickles",
            "A complete e-commerce website for a homemade pickles brand with WhatsApp ordering.",
            "E-Commerce", listOf("HTML", "CSS", "JavaScript", "Netlify"),
            detailsUrl = "projects/nandhu-pickles.html",
            liveUrl = "https://nandhupickles.netlify.app",
            previewIcon = "jar", previewStyle = "pickle"),
        Project(3, "03 — APP", "MyInstaPro",
            "Android app to download Instagram videos, reels, photos and stories — fast, free, no watermark.",
            "Android App", listOf("Android", "Instagram", "Downloader", "No Watermark"),
            isFeatured = true, isNew = true,
            detailsUrl = "projects/myinstapro.html",
            telegramUrl = "https://t.me/madhupatelpspk",
            previewIcon = "instagram", previewStyle = "insta"),
        Project(4, "04 — WEBSITE", "Vigneshwara Youth Group",
            "A community website for a local youth group — events, members, galleries, announcements.",
            "Community", listOf("HTML", "CSS", "JavaScript", "Netlify"),
            detailsUrl = "projects/vigneshwara.html",
            liveUrl = "https://teamvya.netlify.app",
            previewIcon = "people-group", previewStyle = "vya"),
        Project(5, "05 — WEBSITE", "Homecare",
            "A modern homecare services website presenting at-home care info in a clear, approachable way.",
            "Home Services", listOf("Web App", "Responsive UI", "Vercel"),
            detailsUrl = "projects/HomeCare.html",
            liveUrl = "https://homecare-mky9rkq0j-madhupatel.vercel.app/",
            previewIcon = "house-chimney", previewStyle = "pickle"),
        Project(6, "06 — APP", "InstaSaver",
            "Open-source Kotlin Android app to download Instagram Reels, posts, profile pictures. No login, no ads, no tracking.",
            "Android App", listOf("Kotlin", "MVVM", "Android Jetpack", "Material Design"),
            detailsUrl = "projects/InstaSaver.html",
            apkUrl = "https://github.com/pspktech/InstaSaver/releases/latest",
            sourceUrl = "https://github.com/pspktech/InstaSaver",
            previewIcon = "instagram", previewStyle = "insta")
    )
}
