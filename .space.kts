/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("continuous") {
    git {
        depth = UNLIMITED_DEPTH
        refSpec {
            +"refs/heads/*:refs/heads/*"
        }
    }

    container("mcr.microsoft.com/dotnet/sdk:6.0") {
        shellScript {
            content = "dotnet build"
        }
    }

    startOn {
        gitPush {
            enabled = true
        }
    }
}