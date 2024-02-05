package io.stark.data.wrappers

import io.stark.data.model.AuthResponse
import io.stark.domain.model.AuthSetDomainBeam

object AuthResponseWrapper: Wrapper<AuthResponse, AuthSetDomainBeam> {
    override fun wrap(from: AuthResponse): AuthSetDomainBeam {
        return AuthSetDomainBeam(
            from.accessToken,
            from.refreshToken
        )
    }

    override fun unWrap(from: AuthSetDomainBeam): AuthResponse {
        return AuthResponse(
            from.accessToken,
            from.refreshToken
        )
    }
}