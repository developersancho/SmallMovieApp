package com.smallmovieapp.utils

object Helpers {
    fun buildProfileImageUrl(path: String): String {
        return "http://image.tmdb.org/t/p/w185" + path
    }

    fun buildImageUrl(path: String): String {
        return "http://image.tmdb.org/t/p/w342" + path
    }

    fun buildBackdropImageUrl(path: String): String {
        return "http://image.tmdb.org/t/p/w780" + path
    }

    fun buildYouTubeThumbnailURL(key: String): String {
        return "https://img.youtube.com/vi/$key/0.jpg"
    }

    fun buildYoutubeURL(key: String): String {
        return "https://www.youtube.com/watch?v=" + key
    }

    fun getGenre(id: Int): String {
        val genreMap = HashMap<Int, String>()
        genreMap.put(28, "Aksiyon")
        genreMap.put(12, "Macera")
        genreMap.put(16, "Animasyon")
        genreMap.put(35, "Komedi")
        genreMap.put(80, "Suç")
        genreMap.put(99, "Belgesel")
        genreMap.put(18, "Dram")
        genreMap.put(10751, "Aile")
        genreMap.put(14, "Fantezi")
        genreMap.put(36, "Tarih")
        genreMap.put(27, "Korku")
        genreMap.put(10402, "Müzik")
        genreMap.put(9648, "Gizem")
        genreMap.put(10749, "Roman")
        genreMap.put(878, "Bilim Kurgu")
        genreMap.put(10770, "TV Filmi")
        genreMap.put(53, "Thriller")
        genreMap.put(10752, "Savaş")
        genreMap.put(37, "Western")

        return genreMap.get(id)!!
    }

}