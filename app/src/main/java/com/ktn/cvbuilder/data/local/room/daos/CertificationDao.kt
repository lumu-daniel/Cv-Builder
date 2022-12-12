package com.ktn.cvbuilder.data.local.room.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ktn.cvbuilder.data.local.room.entities.CertificationTable

@Dao
interface CertificationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCertificate(certificate: CertificationTable)

    @Delete
    suspend fun deleteCertificate(certificate: CertificationTable)

    @Query("SELECT * FROM certification_table")
    fun observerAllCertificates(): LiveData<List<CertificationTable>>

    @Query("SELECT * FROM certification_table WHERE userId=:userID")
    fun observeCertificationByUserId(userID: String): LiveData<List<CertificationTable>>
}