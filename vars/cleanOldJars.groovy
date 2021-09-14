/**
 * @created 17/11/2020- 10:37
 * @author gmekala* @project taxilla-jenkins-shared-library
 */
import static com.taxilla.jenkins.components.Constants.*

def call() {
    try {
        sh """
        cd $COM_ADAEQUARE_FOLDER_LOCATION
        rm -rf com.adaequare adaequare-etl
        echo "Cleaned files-2.1 com.adaequare folder $COM_ADAEQUARE_FOLDER_LOCATION"   
        sleep 2
        cd $DESCRIPTORS_JAR_FILES_LOCATION
        rm -rf com.adaequare adaequare-etl
        echo "Clean descriptors com.adaequare folder $DESCRIPTORS_JAR_FILES_LOCATION"
      """
    }
    catch (Exception e) {
        println(e)
    }
}

