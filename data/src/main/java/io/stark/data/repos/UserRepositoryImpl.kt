package io.stark.data.repos


import io.stark.data.SomeApi
import io.stark.data.StorageApi
import io.stark.data.bodyOrException
import io.stark.data.wrappers.AuthResponseWrapper
import io.stark.data.wrappers.CreateUserDataWrapper
import io.stark.data.wrappers.LoginUserDataWrapper
import io.stark.domain.model.AuthSetDomainBeam
import io.stark.domain.model.LoginUserDomainBeam
import io.stark.domain.model.UserRegistrationDomainBeam
import io.stark.domain.repository.UserRepository

class UserRepositoryImpl(
    private val someApi: SomeApi,
    private val storageApi: StorageApi
): UserRepository {
    override suspend fun createUser(userData: UserRegistrationDomainBeam) {
        someApi.createNewUser(CreateUserDataWrapper.unWrap(userData))
    }

    override suspend fun loginUser(loginUserDomainBeam: LoginUserDomainBeam): AuthSetDomainBeam {
        val response = someApi.authByLogin(LoginUserDataWrapper.unWrap(loginUserDomainBeam)).execute()
        return AuthResponseWrapper.wrap(response.bodyOrException())
    }

    override suspend fun updateAuthSet(refreshToken: String): AuthSetDomainBeam {
        val response = someApi.authByRefreshToken(refreshToken).execute()
        return AuthResponseWrapper.wrap(response.bodyOrException())
    }

    override suspend fun saveAuthSet(authSetDomainBeam: AuthSetDomainBeam) {
        storageApi.saveMap(
            mapOf(
                Pair(ACCESS_TOKEN, authSetDomainBeam.accessToken),
                Pair(REFRESH_TOKEN, authSetDomainBeam.refreshToken)
            )
        )
    }

    override suspend fun saveLoginData(loginUserDomainBeam: LoginUserDomainBeam) {
        // TODO safety caching
        storageApi.saveMap(
            mapOf(
                Pair(LOGIN, loginUserDomainBeam.login),
                Pair(PASSWORD, loginUserDomainBeam.password)
            )
        )
    }

    override suspend fun getCachedAuthSet(): AuthSetDomainBeam {
        return AuthSetDomainBeam(
            storageApi.getString(ACCESS_TOKEN),
            storageApi.getString(REFRESH_TOKEN)
        )
    }

    override suspend fun getCachedLoginData(): LoginUserDomainBeam {
        return LoginUserDomainBeam(
            storageApi.getString(LOGIN),
            storageApi.getString(PASSWORD)
        )
    }
    companion object {
        const val ACCESS_TOKEN = "accessToken"
        const val REFRESH_TOKEN = "refreshToken"
        const val LOGIN = "login"
        const val PASSWORD = "password"
    }
}