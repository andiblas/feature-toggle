package com.apujadas.feature.rules

import com.apujadas.feature.FeatureContext

class IsUserIdInListRule(val userIds: List<Long>) : Rule {
    override fun satisfies(context: FeatureContext): Boolean {
        return userIds.contains(context.userId)
    }
}
