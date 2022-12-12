package com.ktn.cvbuilder.domain.repositories

import androidx.lifecycle.LiveData
import com.ktn.cvbuilder.data.local.LocalDataAccessApi
import com.ktn.cvbuilder.data.local.room.daos.*
import com.ktn.cvbuilder.data.local.room.entities.*
import javax.inject.Inject


class LocalDataAccessApiImpl @Inject constructor(
    private val userDao: UserDao,
    private val workDao: WorkDao,
    private val educationDao: EducationDao,
    private val contactDao: ContactDao,
    private val certificationDao: CertificationDao
): LocalDataAccessApi {
    override suspend fun insertUser(user: UserTable) {
        userDao.insertUser(user)
    }

    override suspend fun deleteUser(user: UserTable) {
        userDao.deleteUser(user)
    }

    override fun observerAllUser(): LiveData<List<UserTable>> {
        return userDao.observerAllUser()
    }

    override suspend fun insertWork(work: WorkTable) {
        workDao.insertWork(work)
    }

    override suspend fun deleteWork(work: WorkTable) {
        workDao.deleteWork(work)
    }

    override fun observerAllWorks(): LiveData<List<WorkTable>> {
        return workDao.observerAllWorks()
    }

    override fun observeWorkByUserId(userID: String): LiveData<List<WorkTable>> {
        return workDao.observeWorkByUserId(userID)
    }

    override suspend fun insertEducation(education: EducationTable) {
        educationDao.insertEducation(education)
    }

    override suspend fun deleteEducation(education: EducationTable) {
        educationDao.deleteEducation(education)
    }

    override fun observerAllEducations(): LiveData<List<EducationTable>> {
        return educationDao.observerAllEducations()
    }

    override fun observeEducationByUserId(userID: String): LiveData<List<EducationTable>> {
        return educationDao.observeEducationByUserId(userID)
    }

    override suspend fun insertContact(contact: ContactTable) {
        contactDao.insertContact(contact)
    }

    override suspend fun deleteContact(contact: ContactTable) {
        contactDao.deleteContact(contact)
    }

    override fun observerAllContacts(): LiveData<List<ContactTable>> {
        return contactDao.observerAllContacts()
    }

    override fun observeContactByUserId(userID: String): LiveData<List<ContactTable>> {
        return contactDao.observeContactByUserId(userID)
    }

    override suspend fun insertCertificate(certificate: CertificationTable) {
        certificationDao.insertCertificate(certificate)
    }

    override suspend fun deleteCertificate(certificate: CertificationTable) {
        certificationDao.deleteCertificate(certificate)
    }

    override fun observerAllCertificates(): LiveData<List<CertificationTable>> {
        return certificationDao.observerAllCertificates()
    }

    override fun observeCertificationByUserId(userID: String): LiveData<List<CertificationTable>> {
        return certificationDao.observeCertificationByUserId(userID)
    }
}