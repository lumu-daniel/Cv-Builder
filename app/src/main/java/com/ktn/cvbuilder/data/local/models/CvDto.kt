package com.ktn.cvbuilder.data

import androidx.annotation.StringRes

data class CvDto (
    val name:String,
    val password:String,
    val title:String,
    @StringRes val careerNote:Int,
    val experience: Experience,
    @StringRes val aboutMe:Int,
    val educations:List<Education>? = null,
    val certifications:List<Certification>? =null,
    val works:List<Work>? = null,
    val contacts:List<Contact>? = null,
    )

data class Experience(
    val languages:String,
    val frameWorks:String,
    val microServices:String,
    val databases:String,
    val tools:String,
)

data class Education (
    val collageImage:Int,
    val collegeName:String,
    val major:String,
)

data class Certification(
    val certificationImage:Int,
    val certificationName:String,
    val yearAttended:String,
)

data class Work (
    val workImage:Int,
    val companyName:String,
    val job:String,
    val from: String,
    val to: String,
    val city:String,
    val state:String,
    val desc:String
    )

data class Contact (
    val contactIcn:Int,
    val contactType:String,
    val contactValue:String,
    )