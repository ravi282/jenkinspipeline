/**
 * @created 17/11/2020- 10:37
 * @author gmekala* @project taxilla-jenkins-shared-library
 */
import static com.taxilla.jenkins.components.Constants.*

def call(String ENVIRONMENT_TYPE, String CLASSIFIER, String VERSION_TYPE, String PROJECT_NAME, String SRC_ZIP_PATH) {
    def SOURCE_LOCATION
    SOURCE_LOCATION = "${CUSTOM_WORKSPACE}${PROJECT_NAME}${env.JOB_BASE_NAME}"
    echo "$SOURCE_LOCATION$SRC_ZIP_PATH"
    if (ENVIRONMENT_TYPE.contains("qa")) {
        nexusArtifactUploader artifacts: [[artifactId: "${env.JOB_BASE_NAME}",
                                           classifier: "$CLASSIFIER",
                                           file      : "$SOURCE_LOCATION$SRC_ZIP_PATH",
                                           type      : 'zip']], credentialsId: "$NEXUS_CREDENTIAIL_ID",
                groupId: "$QA_GROUP_ID",
                nexusUrl: "$NEXUS_REPOSITORY_URL",
                nexusVersion: "$NEXUS_VERSION",
                protocol: "$PROTOCOL_TYPE",
                repository: "$REPOSITORY_QA",
                version: "$VERSION_TYPE"
        sleep 5
    } else if (ENVIRONMENT_TYPE.contains("prod")) {
        nexusArtifactUploader artifacts: [[artifactId: "$ARTIFACT_ID",
                                           classifier: "$CLASSIFIER",
                                           file      : "$SOURCE_LOCATION$SRC_ZIP_PATH",
                                           type      : 'zip']], credentialsId: "$NEXUS_CREDENTIAIL_ID",
                groupId: "$PROD_GROUP_ID",
                nexusUrl: "$NEXUS_REPOSITORY_URL",
                nexusVersion: "$NEXUS_VERSION",
                protocol: "$PROTOCOL_TYPE",
                repository: "$REPOSITORY_PROD",
                version: "$VERSION_TYPE"
        sleep 5

    }

}




