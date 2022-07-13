package com.poilkar.nehank.paging3_networkonly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.poilkar.nehank.paging3_networkonly.databinding.ActivityMainBinding
import com.poilkar.nehank.paging3_networkonly.paging.PictureLoaderAdapter
import com.poilkar.nehank.paging3_networkonly.paging.PicturePagingAdapter
import com.poilkar.nehank.paging3_networkonly.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MainViewModel
    lateinit var pictureAdapter : PicturePagingAdapter

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        init()
        setObservers()
    }

    private fun init(){
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        pictureAdapter = PicturePagingAdapter(this)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = pictureAdapter.withLoadStateHeaderAndFooter(
                header = PictureLoaderAdapter(),
                footer = PictureLoaderAdapter()
            )
        }
    }

    private fun setObservers(){

        lifecycleScope.launch {
            viewModel.result.collect {
                pictureAdapter.submitData(it)
            }
        }


    }


}