/**
 * @created 17/11/2020- 10:37
 * @author gmekala* @project taxilla-jenkins-shared-library
 */
import static com.taxilla.jenkins.components.Constants.*
import static com.taxilla.jenkins.components.Constants.VDM_ZIP

def call(final String PROJECT_NAME, String GRADLE_MAVEN_NPM_BUILD_COMMAND, String BUILD_TOOL) {
    def SOURCE_LOCATION
    SOURCE_LOCATION = "${CUSTOM_WORKSPACE}${PROJECT_NAME}${env.JOB_BASE_NAME}"
    if (BUILD_TOOL.contains("gspqa")) {
        dir("$SOURCE_LOCATION") {
            def MavenHome = tool MAVEN_HOME
            // run Maven to execute compile
            sh "cd $SOURCE_LOCATION"
            sh "'${MavenHome}' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
            sh "mvn -version"
            sh """
            cd $SOURCE_LOCATION${GSP_QA}"
            zip -r $ROOT_ZIP $ROOT
            sleep 5
            zip -r $GSTWRAPPER_ZIP $GSTWRAPPER
            sleep 5
            chmod -R 755 $GSPUI
            zip -r gspuiQA.zip $GSPUI
            sleep 10 
            """
        }
    } else if (BUILD_TOOL.contains("gspuat")) {
        dir("$SOURCE_LOCATION") {
            def MavenHome = tool MAVEN_HOME
            // run Maven to execute compile
            sh "cd $SOURCE_LOCATION"
            sh "'${MavenHome}' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
            sh "mvn -version"
            sh """
            cd $SOURCE_LOCATION${GSP_UAT}"
            zip -r $ROOT_ZIP $ROOT
            sleep 5
            zip -r $GSTWRAPPER_ZIP $GSTWRAPPER
            sleep 5
            chmod -R 755 $GSPUI
            zip -r gspuiuat.zip $GSPUI
            sleep 10 
            """
        }
    } else if (BUILD_TOOL.contains("etl")) {
        dir("$SOURCE_LOCATION$ETL_COMPILE_LOCATION") {
            def gradleHome = tool GRADLE_VERSION
            // run Gradle to execute compile
            sh "java -version"
            sh "cd $SOURCE_LOCATION$ETL_COMPILE_LOCATION"
            sh "'${gradleHome}/bin/gradle' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
            sh """
                cd $SOURCE_LOCATION$ETL_COMPILE_LOCATION${ETL_BINARIES_PATH}
                chmod -R 755 *.war
                mv *.war $ETL
                zip -r $ETL_ZIP $ETL    
            """
        }
    } else if (BUILD_TOOL.contains("vdm")) {
        dir("$SOURCE_LOCATION$MACRE_COMPILE_LOCATION") {
            def gradleHome = tool GRADLE_VERSION
            // run Gradle to execute compile
            sh "cd $SOURCE_LOCATION$MACRE_COMPILE_LOCATION"
            sh "'${gradleHome}/bin/gradle' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
            sh """
            cd $SOURCE_LOCATION$MACRE_COMPILE_LOCATION${MACRE_BINARIES_PATH}
            
            mv $ROOT $VDM_WAR
            chmod -R 755 $VDM_WAR
            zip -r $VDM_ZIP $VDM_WAR        
            """
        }
    } else if (BUILD_TOOL.contains("mapro")) {
        dir("$SOURCE_LOCATION") {
            def gradleHome = tool GRADLE_VERSION
            // run Gradle to execute compile
            sh "cd $SOURCE_LOCATION"
            sh "'${gradleHome}/bin/gradle' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
            sh """
            cd $SOURCE_LOCATION$TAXILLA_BINARIES_PATH
            chmod -R 755 $TAXILLA_ZIP                
            """
        }
    } else if (BUILD_TOOL.contains("search")) {
        dir("$SOURCE_LOCATION") {
            def gradleHome = tool GRADLE_VERSION
            // run Gradle to execute compile
            sh "cd $SOURCE_LOCATION"
            sh "'${gradleHome}/bin/gradle' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
            sh """
            cd $SOURCE_LOCATION$SEARCH_BINARIES_PATH
            chmod -R 755 $SEARCH_ZIP                
            """
        }
    } else if (BUILD_TOOL.contains("user")) {
        dir("$SOURCE_LOCATION") {
            def gradleHome = tool GRADLE_VERSION
            // run Gradle to execute compile
            sh "cd $SOURCE_LOCATION"
            sh "'${gradleHome}/bin/gradle' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
            sh """
            cd $SOURCE_LOCATION$USER_BINARIES_PATH
            chmod -R 755 $USER_ZIP                
            """
        }

    } else if (BUILD_TOOL.contains("eninvoice")) {
        dir("$SOURCE_LOCATION") {
            def gradleHome = tool GRADLE_VERSION
            // run Gradle to execute compile
            sh "cd $SOURCE_LOCATION"
            sh "'${gradleHome}/bin/gradle' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
            sh """
            cd $SOURCE_LOCATION$ENINVOICE_BACKEND_PATH
            chmod -R 755 $ENINVOICE_ZIP               
            """
        }
    } else if (BUILD_TOOL.contains("gmap")) {
        dir("$SOURCE_LOCATION") {
            def gradleHome = tool GRADLE_VERSION
            // run Gradle to execute compile
            sh "cd $SOURCE_LOCATION"
            sh "'${gradleHome}/bin/gradle' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
            sh """
            cd $SOURCE_LOCATION$GMAP_UTILS_PATH
            chmod -R 755 $APPLICATION_ZIP               
            """
        }
    } else if (BUILD_TOOL.contains("property")) {
        dir("$SOURCE_LOCATION") {
            def gradleHome = tool GRADLE_VERSION
            // run Gradle to execute compile
            sh "cd $SOURCE_LOCATION$PROPERTY_LOADER_COMPILE_LOCATION"
            sh "'${gradleHome}/bin/gradle' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
            sh """
            cd $SOURCE_LOCATION$PROPERTY_LOADER_PATH
            zip -r property-loader.zip $PROPERTY_LOADER_JAR
            chmod -R 755 $PROPERTY_LOADER               
            """
        }
    } else if (BUILD_TOOL.contains("addtax")) {
        dir("$SOURCE_LOCATION") {
            def gradleHome = tool GRADLE_VERSION
            // run Gradle to execute compile
            sh "cd $SOURCE_LOCATION"
            sh "'${gradleHome}/bin/gradle' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
            sh """
            cd $SOURCE_LOCATION$ADDTAX_PATH
            chmod -R 755 $ADDTAX_ZIP               
            """
        }
    } else if (BUILD_TOOL.contains("fvu")) {
        dir("$SOURCE_LOCATION") {
            def gradleHome = tool GRADLE_VERSION
            // run Gradle to execute compile
            sh "cd $SOURCE_LOCATION"
            sh "'${gradleHome}/bin/gradle' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
            sh """
            cd $SOURCE_LOCATION$FVU_PATH
            mv fvu-*.jar $FVU_JAR
            zip -r $FVU_ZIP $FVU_JAR
            chmod -R 755 $FVU_ZIP               
            """
        }
    } else if (BUILD_TOOL.contains("macreui")) {
        dir("$SOURCE_LOCATION") {
            def gradleHome = tool GRADLE_VERSION
            // run Gradle to execute compile
            sh "cd $SOURCE_LOCATION"
            sh "npm install"
            sh "$GRADLE_MAVEN_NPM_BUILD_COMMAND"
            sh """
            cd $SOURCE_LOCATION$UI_PATH
            rm -rf app.zip
            chmod -R 755 $MACREUI_NAME
            zip -r $MACEUI_ZIP $MACREUI_NAME
            """
        }
    } else if (BUILD_TOOL.contains("taxillaui")) {
        dir("$SOURCE_LOCATION") {
            def gradleHome = tool GRADLE_VERSION
            // run Gradle to execute compile
            sh "cd $SOURCE_LOCATION"
            sh "npm install"
            sh "npm run build:$GRADLE_MAVEN_NPM_BUILD_COMMAND"
            sh """
            cd $SOURCE_LOCATION$UI_PATH
            rm -rf app.zip
            chmod -R 755 $TAXILLA_UI_FOLDER
            zip -r $TAXILLA_UI_ZIP $TAXILLA_UI_FOLDER
            """
        }
    } else if (BUILD_TOOL.contains("gradle")) {
        if (isUnix()) {
            def gradleHome = tool GRADLE_VERSION
            sh "'${gradleHome}/bin/gradle' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
        } else {
            def gradleHome = tool GRADLE_VERSION
            bat "'${gradleHome}/bin/gradle' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
        }
    } else if (BUILD_TOOL.contains("maven")) {
        if (isUnix()) {
            def MavenHome = tool MAVEN_HOME
            sh "'${MavenHome}' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
        } else {
            def MavenHome = tool MAVEN_HOME
            bat "'${MavenHome}' $GRADLE_MAVEN_NPM_BUILD_COMMAND"
        }

    }

}