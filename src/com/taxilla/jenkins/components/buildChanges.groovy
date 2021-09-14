package com.taxilla.jenkins.components

/**
 * @created 17/11/2020- 22:53
 * @author gmekala* @project taxilla-jenkins-shared-library
 */
class buildChanges {
    //def changes() {
        def commitList = {
            def changes = ""
            currentBuild.changeSets.each { set ->
                set.each { entry ->
                    changes += "${entry.commitId} - ${entry.msg} \n by ${entry.author.fullName}\n"
                }
            }
            return changes
        }
    }
//}