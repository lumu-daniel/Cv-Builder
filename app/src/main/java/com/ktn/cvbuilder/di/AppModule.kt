package com.ktn.cvbuilder.di

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.data.local.LocalDataAccessApi
import com.ktn.cvbuilder.data.local.room.CvDatabase
import com.ktn.cvbuilder.data.local.room.daos.*
import com.ktn.cvbuilder.domain.repositories.LocalDataAccessApiImpl
import com.ktn.cvbuilder.orther.Constants.DATABASE_NAME
import com.ktn.cvbuilder.ui.fragments.*
import com.ktn.cvbuilder.ui.fragments.adapters.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
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

@Module
@InstallIn(SingletonComponent::class)
object AppModule{
    @Singleton
    @Provides
    fun provideCvDatabaseItemDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context,CvDatabase::class.java,DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideUserDao(
        database: CvDatabase
    ) = database.userDao()

    @Singleton
    @Provides
    fun provideContactDao(
        database: CvDatabase
    ) = database.contactDao()

    @Singleton
    @Provides
    fun provideEducationDao(
        database: CvDatabase
    ) = database.educationDao()

    @Singleton
    @Provides
    fun provideWorkDao(
        database: CvDatabase
    ) = database.workDao()

    @Singleton
    @Provides
    fun provideCertificationDao(
        database: CvDatabase
    ) = database.certificationDao()

    @Singleton
    @Provides
    fun provideLocalDataAccessRepository(
        userDao: UserDao,
        contactDao: ContactDao,
        educationDao: EducationDao,
        workDao: WorkDao,
        certificationDao: CertificationDao
    ) = LocalDataAccessApiImpl(
        userDao,
        workDao,
        educationDao,
        contactDao,
        certificationDao
    ) as LocalDataAccessApi

}

