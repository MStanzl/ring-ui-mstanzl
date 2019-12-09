package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildFeatures.CommitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v2018_2.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v2018_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'ConsoleErrors'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("ConsoleErrors")) {
    params {
        expect {
            param("npmjs.com.auth.key", "")
        }
        update {
            param("npmjs.com.auth.key", "credentialsJSON:7f08c5e7-ed45-4767-b103-5802c98c1d6c")
        }
    }

    features {
        val feature1 = find<CommitStatusPublisher> {
            commitStatusPublisher {
                publisher = upsource {
                    serverUrl = "https://upsource.jetbrains.com"
                    projectId = "ring-ui"
                    userName = "TeamCityReporter"
                    password = "credentialsJSON:9eaa3cf0-4b14-49db-83f2-b141b3721922"
                }
            }
        }
        feature1.apply {
            enabled = false
        }
    }
}
