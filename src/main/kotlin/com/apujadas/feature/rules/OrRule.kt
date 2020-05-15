package com.apujadas.feature.rules

import com.apujadas.feature.FeatureContext

class OrRule(val rules: MutableList<Rule>) : Rule {

    fun or(secondRule: Rule) = apply { rules.add(secondRule) }

    override fun satisfies(context: FeatureContext): Boolean {
        for (rule in rules) {
            if (rule.satisfies(context))
                return true
        }
        return false
    }
}
