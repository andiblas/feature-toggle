package com.apujadas.feature.rules

import com.apujadas.feature.FeatureContext
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.PROPERTY, property="@type")
class AlwaysTrueRule : Rule {
    override fun satisfies(context: FeatureContext): Boolean {
        return true
    }

}
