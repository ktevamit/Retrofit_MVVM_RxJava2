package net.apps2u.retrofit_mvvm_rxjava2.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import net.apps2u.retrofit_mvvm_rxjava2.databinding.ActivityMainBinding
import net.apps2u.retrofit_mvvm_rxjava2.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private val movieAdapter: MovieAdapter = MovieAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel= ViewModelProvider(this).get(MovieViewModel::class.java)
        viewModel.refresh()

        binding.movieRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.movies.observe(this) {
            it?.let {
                movieAdapter.updateMovieList(it)
            }
        }
    }
}