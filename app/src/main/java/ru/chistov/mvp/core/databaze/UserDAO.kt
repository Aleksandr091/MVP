package ru.chistov.mvp.core.databaze

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
abstract class UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(userDBObject: UserDBObject): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertALL(usersDBObject: List<UserDBObject>): Completable

    @Query("SELECT * FROM users")
    abstract fun queryForALLUsers(): Single<List<UserDBObject>>

    @Query("SELECT * FROM users WHERE login = :login")
    abstract fun queryForUsers(login: String): Single<UserDBObject>

    @Delete
    abstract fun delete(userDBObject: UserDBObject): Completable

    @Transaction
    @Query("SELECT * FROM users WHERE login = :login")
    abstract fun getUserWithRepos(login: String): Single<UserWithReposDBObject>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertRepo(reposDBObject: List<RepoDBObject>): Completable

    @Query("SELECT * FROM repos WHERE userId = :userId")
    abstract fun queryForReposUser(userId: String): Single<List<RepoDBObject>>

}