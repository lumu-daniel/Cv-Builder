package com.ktn.cvbuilder.data.local

import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.data.*

object LocalDataSource {

    val cvDto = CvDto(
        name = "Kyobe Daniel Lumu",
        password = "",
        title = "Android Software Engineer",
        careerNote = R.string.career_note,
        experience = Experience(
            languages = "Java, Kotlin, Dart",
            frameWorks = "Native, Flutter",
            microServices = "AWS, GCP, Docker, Kubernetes, Kafka",
            databases = "Room, MySQL, mongoDB",
            tools = "Android Studio, Intellij, Vs Code"
        ),
        aboutMe = R.string.about_me,
        contacts = listOf(
            Contact(R.drawable.icn_phone,"+1(641)233-1337","Mobile"),
            Contact(R.drawable.icn_mail,"lumukd@gmail.com","Email"),
            Contact(R.drawable.icn_linkedin,"https://www.linkedin.com/in/kyobelumu/","LinkedIn WebSite"),
            Contact(R.drawable.icn_github,"https://github.com/lumu-daniel","Github WebSite"),
            Contact(R.drawable.icn_pdf,"Kyobe.Lumu-Resume.pdf","PDF"),
            Contact(R.drawable.icn_person,"https://kyobedaniellumu.me/","Personal Website")
        ),
        certifications = listOf(
            Certification(R.drawable.icn_oracle,"OCA Java 8 Programmer 1(2020)","2020"),
            Certification(R.drawable.icn_mcf,"Microsoft Certified Fundamentals 1(2021)","2021")
        ),
        educations = listOf(
            Education(R.drawable.icn_maharishi,"Maharishi International University","Masters of science in computer science"),
            Education(R.drawable.icn_mit,"Massachusetts Institute of Technology","Bachelors of science in computer science")
        ),
        works = listOf(
            Work(R.drawable.icn_google,"Google","Software Developer","Apr 2020","Present","LA","USA","Developing Flutter Apps"),
            Work(R.drawable.icn_oracle,"Oracle","Database Developer","Jul 2018","Apr 2020","SF","USA","Building Database Tables"),
            Work(R.drawable.icn_mcf,"Microsoft","Database Admin","Oct 2017","Jul 2018","SF","USA","Managing SQLserver Database"),
            Work(R.drawable.icn_ibm,"IBM","Database Admin","Apr 2015","Apr 2017","NY","USA","Managing AS400 Database"),
        )
    )
}