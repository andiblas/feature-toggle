package com.apujadas.feature.rules

import com.apujadas.feature.FeatureContext

class AndRule(val rules: MutableList<Rule>) : Rule {

    fun and(secondRule: Rule) = apply { rules.add(secondRule) }

    override fun satisfies(context: FeatureContext): Boolean {
        for (rule in rules) {
            if (!rule.satisfies(context))
                return false
        }
        return true
    }
}
