package com.apujadas.feature.rules

import com.apujadas.feature.FeatureContext

class IsPercentageUserIdRule(val percentage: Int) : Rule {
    override fun satisfies(context: FeatureContext): Boolean {
        return context.userId % (100 / percentage) == 0L
    }
}
