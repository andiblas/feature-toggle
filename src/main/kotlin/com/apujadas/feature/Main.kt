package com.apujadas.feature

import com.apujadas.feature.rules.IsExactUserIdRule
import com.apujadas.feature.rules.Rule
import com.apujadas.feature.rules.repository.InMemoryRuleRepository
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper


fun main() {
    val featureRepo = InMemoryRuleRepository()
    val featureService = FeatureService(featureRepo)

    val feature1IsEnabled = featureService.isFeatureEnabled("feature1", FeatureContext(1000, "MLA"), false)
    val feature2IsEnabled = featureService.isFeatureEnabled("feature2", FeatureContext(1000, "MLA"), false)
    val feature3IsEnabled = featureService.isFeatureEnabled("feature3", FeatureContext(1000, "MLB"), false)

    featureService.isFeature("feature1").with().userId(1000L).siteId("MLA").enabled()

    println("Is feature1 enabled? $feature1IsEnabled")
    println("Is feature2 enabled? $feature2IsEnabled")
    println("Is feature3 enabled? $feature3IsEnabled")

    val mapper = jacksonObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        .enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING)
        .enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)


    val rule: Rule = IsExactUserIdRule(1000L)

    println("Print1: ${mapper.writeValueAsString(featureRepo.get("feature1"))}")
    println("Print2: ${mapper.writeValueAsString(featureRepo.get("feature2"))}")
    println("Print3: ${mapper.writeValueAsString(featureRepo.get("feature3"))}")
    println("Print4: ${mapper.writeValueAsString(featureRepo.get("feature4"))}")


}
