package com.apujadas.feature

import com.apujadas.feature.rules.RuleNotFoundException
import com.apujadas.feature.rules.repository.RuleRepository

class FeatureService(
    val ruleRepository: RuleRepository
) {
    fun isFeature(featureName: String): OngoingFeatureRequest {
        return OngoingFeatureRequest(this).apply { this.featureName = featureName }
    }

    internal fun isFeatureEnabled(featureName: String, context: FeatureContext, defaultValue: Boolean): Boolean {
        return try {
            val ruleForFeature = ruleRepository.get(featureName)
            ruleForFeature.satisfies(context)
        } catch (e: RuleNotFoundException) {
            defaultValue
        }
    }
}

class OngoingFeatureRequest(val featureService: FeatureService) {
    var featureName: String = ""
    var userId: Long = 0L
    var siteId: String = ""
    var defaultValue: Boolean = false

    fun with(): OngoingFeatureRequest {
        return this
    }

    fun userId(userId: Long) = apply { this.userId = userId }
    fun siteId(siteId: String) = apply { this.siteId = siteId }
    fun defaultValue(defaultValue: Boolean) = apply { this.defaultValue = defaultValue }
    fun enabled(): Boolean {
        return featureService.isFeatureEnabled(featureName, FeatureContext(userId, siteId), defaultValue)
    }
}
