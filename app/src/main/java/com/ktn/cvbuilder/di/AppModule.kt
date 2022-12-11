package com.ktn.cvbuilder.di

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.facebook.CallbackManager
import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.ui.fragments.*
import com.ktn.cvbuilder.ui.fragments.adapters.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    @ActivityScoped
    fun provideGlide(@ActivityContext context: Context)
            = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.ic_image)
            .error(R.drawable.ic_image)
    )

    @Provides
    @ActivityScoped
    fun provideContactsAdapter()
            = ContactsAdapter()

    @Provides
    @ActivityScoped
    fun provideCertificationAdapter(glide: RequestManager)
    = CertificationAdapter(glide)

    @Provides
    @ActivityScoped
    fun provideWorkAdapter(glide: RequestManager)
    = WorkAdapter(glide)

    @Provides
    @ActivityScoped
    fun provideEducationAdapter(glide: RequestManager)
    = EducationAdapter(glide)

    @Provides
    @ActivityScoped
    fun provideFragmentAdapter(@ActivityContext activityContext: Context,
    contactsAdapter: ContactsAdapter,
    certificationAdapter: CertificationAdapter,
    educationAdapter: EducationAdapter,
    workAdapter: WorkAdapter)
    = SectionsPagerAdapter(activityContext as FragmentActivity,
        listOf(
        HolderFragment.FragmentInfo("Home", HomeFragment()),
        HolderFragment.FragmentInfo("About Me", AboutMeFragment(educationAdapter,certificationAdapter)),
        HolderFragment.FragmentInfo("Work", WorkFragment(workAdapter)),
        HolderFragment.FragmentInfo("Contacts", ContactFragment(contactsAdapter))
    ))

}

