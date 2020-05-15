# feature-toggle
Super mini feature toggle implementation

## Usage

```
featureService.isFeature("feature1").with().userId(1000L).siteId("MLA").defaultValue(false).enabled()
```

Extensible Rule Engine with JSON Rules

```
{ "@type": "IsExactUserIdRule", "userid": 1000 }
```
```
{ "@type": "IsExactSiteIdRule", "site_id": "MLA" }
```
```
{ "@type": "IsPercentageUserIdRule", "percentage": 50 }
```
```
{ "@type": "IsNotSiteIdRule", "site_id": "MLB" }
```
```
{ "@type": "AndRule","rules":[ { "@type": "IsPercentageUserIdRule", "percentage": 50}, { "@type": "IsExactSiteIdRule", "site_id": "MLA" }]}
```
```
{ "@type": "OrRule","rules":[ { "@type": "IsPercentageUserIdRule", "percentage": 50}, { "@type": "IsExactSiteIdRule", "site_id": "MLA" }]}
```
