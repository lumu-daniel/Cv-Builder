package com.ktn.cvbuilder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ktn.cvbuilder.data.local.LocalDataSource
import com.ktn.cvbuilder.ui.CvFragmentFactory
import com.ktn.cvbuilder.ui.cvViewModel.CvViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentFactory: CvFragmentFactory

    lateinit var viewModel: CvViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[CvViewModel::class.java]
        viewModel.setCvDto(LocalDataSource.cvDto)
        supportFragmentManager.fragmentFactory = fragmentFactory
        setContentView(R.layout.activity_main)
    }
}