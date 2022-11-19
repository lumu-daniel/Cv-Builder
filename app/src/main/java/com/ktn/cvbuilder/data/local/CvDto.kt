package com.ktn.cvbuilder.data

import java.time.LocalDateTime

data class CvDto (
    val name:String,
    val title:String,
    val careerNote:String,
    val experience: Experience,
    val aboutMe:String,
    val educations:List<Education>,
    val certifications:List<Certification>,
    val works:List<Work>,
    val contacts:List<Contact>,
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
    val collegeName:String,
    val yearAttended:String,
)

data class Work (
    val workImage:Int,
    val companyName:String,
    val from: LocalDateTime,
    val to: LocalDateTime,
    val city:String,
    val state:String
    )

data class Contact (
    val contactIcn:Int,
    val contactType:String,
    val contactValue:String,
    )