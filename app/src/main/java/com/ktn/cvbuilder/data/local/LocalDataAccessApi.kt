package com.ktn.cvbuilder.data.local

import androidx.lifecycle.LiveData
import com.ktn.cvbuilder.data.local.room.entities.*

interface LocalDataAccessApi {

    //User
    suspend fun insertUser(user: UserTable)

    suspend fun deleteUser(user: UserTable)

    fun observerAllUser(): LiveData<List<UserTable>>

    //Work
    suspend fun insertWork(work: WorkTable)

    suspend fun deleteWork(work: WorkTable)

    fun observerAllWorks(): LiveData<List<WorkTable>>

    fun observeWorkByUserId(userID: String): LiveData<List<WorkTable>>

    //Education
    suspend fun insertEducation(education: EducationTable)

    suspend fun deleteEducation(education: EducationTable)

    fun observerAllEducations(): LiveData<List<EducationTable>>

    fun observeEducationByUserId(userID: String): LiveData<List<EducationTable>>

    //Contacts
    suspend fun insertContact(contact: ContactTable)

    suspend fun deleteContact(contact: ContactTable)

    fun observerAllContacts(): LiveData<List<ContactTable>>

    fun observeContactByUserId(userID: String): LiveData<List<ContactTable>>

    //Certificates
    suspend fun insertCertificate(certificate: CertificationTable)

    suspend fun deleteCertificate(certificate: CertificationTable)

    fun observerAllCertificates(): LiveData<List<CertificationTable>>

    fun observeCertificationByUserId(userID: String): LiveData<List<CertificationTable>>

}