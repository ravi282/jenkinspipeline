/**
 * @created 17/11/2020- 10:37
 * @author gmekala* @project taxilla-jenkins-shared-library
 */
def call(){
    sh 'curl -OL https://bitbucket.org/taxilla/taxilla-jenkins-shared-library/src/master/pipeline.properties'
    def pipeline_props = readProperties file: 'pipeline.properties'
}