/**
 * @created 17/11/2020- 10:37
 * @author gmekala* @project taxilla-jenkins-shared-library
 */
import static com.taxilla.jenkins.components.Constants.*

def $ScmURL
def call(final String ScmURL, String BranchName, String DirName) {

    checkout([$class           : 'GitSCM',
              branches         : [[name: "$BranchName"]],
              extensions       : [[$class: 'CloneOption', timeout: 60,]],
              extensions       : [[$class: 'RelativeTargetDirectory', relativeTargetDir: CUSTOM_WORKSPACE + "$DirName"+"${env.JOB_BASE_NAME}"]],
              gitTool          : 'Default',
              userRemoteConfigs: [[credentialsId: BITBUCKET_CREDENTIAIL_ID1, url: "$ScmURL"]]])
}


