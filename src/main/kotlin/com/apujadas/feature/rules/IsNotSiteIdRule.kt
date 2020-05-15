package com.apujadas.feature.rules

import com.apujadas.feature.FeatureContext

class IsNotSiteIdRule(val siteId: String) : Rule {
    override fun satisfies(context: FeatureContext): Boolean {
        return siteId != context.siteId
    }

}
