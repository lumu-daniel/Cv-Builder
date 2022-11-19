package com.ktn.cvbuilder.di

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.ktn.cvbuilder.ui.CvViewModel
import com.ktn.cvbuilder.ui.SectionsPagerAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    @ActivityScoped
    fun provideFragmentAdapter(@ActivityContext activityContext: Context)
    = SectionsPagerAdapter(activityContext as FragmentActivity)

    @Provides
    fun provideCvViewModel(@ActivityContext activityContext: Context)
    = ViewModelProvider(activityContext as FragmentActivity)[CvViewModel::class.java]
}

