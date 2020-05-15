package com.apujadas.feature.rules

import com.apujadas.feature.FeatureContext
import com.fasterxml.jackson.annotation.JsonTypeInfo

class IsExactUserIdRule(val userid: Long) : Rule {
    override fun satisfies(context: FeatureContext): Boolean {
        return userid == context.userId
    }
}
