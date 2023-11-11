package com.example.randomfilmapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var moviesArray: Array<String>
    private lateinit var textViewMovie: TextView
    private var usedMovies: MutableSet<String> = mutableSetOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviesArray = resources.getStringArray(R.array.movies_array)
        textViewMovie = findViewById(R.id.textViewMovie)

        val buttonShowMovie: Button = findViewById(R.id.buttonShowMovie)
        val buttonReset: Button = findViewById(R.id.buttonReset)

        buttonShowMovie.setOnClickListener { showRandomMovie() }
        buttonReset.setOnClickListener { resetMovies() }
    }

    private fun showRandomMovie() {
        if (usedMovies.size == moviesArray.size) {
            textViewMovie.text = "Все фильмы просмотрены. Сбросьте список."
            return
        }

        var randomMovie: String
        do {
            randomMovie = moviesArray.random()
        } while (usedMovies.contains(randomMovie))

        usedMovies.add(randomMovie)
        textViewMovie.text = randomMovie
    }

    private fun resetMovies() {
        usedMovies.clear()
        textViewMovie.text = ""
    }
}
