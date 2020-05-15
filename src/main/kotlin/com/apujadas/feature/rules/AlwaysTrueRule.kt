package com.apujadas.feature.rules

import com.apujadas.feature.FeatureContext

class AlwaysTrueRule : Rule {
    override fun satisfies(context: FeatureContext): Boolean {
        return true
    }
}
