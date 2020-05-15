package com.apujadas.feature.rules

import com.apujadas.feature.FeatureContext

class AlwaysFalseRule : Rule {
    override fun satisfies(context: FeatureContext): Boolean {
        return false
    }
}
