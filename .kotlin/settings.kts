import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.vcs

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2025.07"

project {

    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        dotnetBuild {
            name = "dotnet"
            id = "dotnet"
            enabled = false
        }
        dotnetBuild {
            name = "dotnet2"
            id = "dotnet2"
            enabled = false
        }
        script {
            name = "Progress"
            id = "Progress"
            enabled = false
            scriptContent = "echo"
        }
        script {
            name = "Progress1"
            id = "Progress1"
            scriptContent = "echo"
        }
        script {
            name = "Progress2"
            id = "Progress2"
            scriptContent = "echo"
        }
        script {
            name = "Progress3"
            id = "Progress3"
            scriptContent = "echo"
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})
