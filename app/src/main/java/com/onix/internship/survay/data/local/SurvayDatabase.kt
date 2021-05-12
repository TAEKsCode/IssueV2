package com.onix.internship.survay.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.onix.internship.survay.data.local.tables.access.Access
import com.onix.internship.survay.data.local.tables.access.AccessDao
import com.onix.internship.survay.data.local.tables.answer.Answer
import com.onix.internship.survay.data.local.tables.answer.AnswersDao
import com.onix.internship.survay.data.local.tables.auth.Auth
import com.onix.internship.survay.data.local.tables.auth.AuthDao
import com.onix.internship.survay.data.local.tables.question.Question
import com.onix.internship.survay.data.local.tables.question.QuestionsDao
import com.onix.internship.survay.data.local.tables.result.Result
import com.onix.internship.survay.data.local.tables.result.ResultDao
import com.onix.internship.survay.data.local.tables.role.Role
import com.onix.internship.survay.data.local.tables.role.RolesDao
import com.onix.internship.survay.data.local.tables.test.Test
import com.onix.internship.survay.data.local.tables.test.TestsDao
import com.onix.internship.survay.data.local.tables.user.User
import com.onix.internship.survay.data.local.tables.user.UsersDao

@Database(
    entities = [Access::class, Answer::class, Question::class, Result::class, Test::class, Role::class, User::class, Auth::class],
    version = 1,
    exportSchema = false
)
abstract class SurvayDatabase : RoomDatabase() {

    abstract val accessDao: AccessDao
    abstract val answersDao: AnswersDao
    abstract val questionDao: QuestionsDao
    abstract val resultDao: ResultDao
    abstract val roleDao: RolesDao
    abstract val testDao: TestsDao
    abstract val userDao: UsersDao
    abstract val authDao: AuthDao

    companion object {

        @Volatile
        private var INSTANCE: SurvayDatabase? = null

        fun getInstance(context: Context): SurvayDatabase {

            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SurvayDatabase::class.java,
                        "survay_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}