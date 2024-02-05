package io.stark.data.wrappers

import io.stark.data.model.LoginUserData
import io.stark.domain.model.LoginUserDomainBeam

object LoginUserDataWrapper: Wrapper<LoginUserData, LoginUserDomainBeam> {
    override fun wrap(from: LoginUserData): LoginUserDomainBeam {
        return LoginUserDomainBeam(
            from.login,
            from.password
        )
    }

    override fun unWrap(from: LoginUserDomainBeam): LoginUserData {
        return LoginUserData(
            from.login,
            from.password
        )
    }
}