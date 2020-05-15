package com.apujadas.feature.rules.repository

import com.apujadas.feature.rules.*

class InMemoryRuleRepository : RuleRepository {

    private val ruleMap = mapOf(
        "feature1" to IsExactUserIdRule(1000),
        "feature2" to IsExactSiteIdRule("MLA"),
        "feature3" to AndRule(mutableListOf(IsPercentageUserIdRule(50))).and(IsExactSiteIdRule("MLA")),
        "feature4" to IsNotSiteIdRule("MLB")
    )

    override fun get(featureName: String): Rule = ruleMap[featureName] ?: throw RuleNotFoundException()
}
