package com.apujadas.feature.rules.repository

import com.apujadas.feature.rules.Rule

interface RuleRepository {
    fun get(featureName: String): Rule
}
