##Declarative Pipeline - taxilla-jenkins-Shared-library
- This repository holds the Jenkins shared library for Taxilla Continuous Integration (CI) and Continuous Delivery (CD) process.
----------------------------------------------------------------------------------------------------------------------------------------------------
##Types Of Pipeline Scripts
- **declarative p.** -> must be enclosed within a `pipeline {}` 
- **scripted p.** -> always are enclosed within a `node {}` block
----------------------------------------------------------------------------------------------------------------------------------------------------
##Prerequisites For Setting Up Library
- It’s always recommended to use libraries for common logic used across all the Jenkins pipelines. 
  ease of maintenance and most importantly, reusability.
- configure Jenkins shared-library repository in Jenkins Admin 
- `Jenkinsfile` will be deployed in each repository (**must** be in project root dir)
- shared library must be imported, and the pipeline function must be called
----------------------------------------------------------------------------------------------------------------------------------------------------
##Setting Up Global Pipeline Library In Jenkins
- Go to **Manage Jenkins -> Configure System -> Global pipeline libraries -> Add**
- Give a name to the library and set default version as develop or master.
- In retrieval method, select Modern SCM and then select Git.
- Provide the URL of this repository and then provide credentials.
----------------------------------------------------------------------------------------------------------------------------------------------------
##.Jenkinsfile
[source,groovy]
----
## Import Library In Your Jenkins Pipeline
- Add the line at the top of your Jenkinsfile that looks like `@Library(‘<name of the library>’) _`
- Optionally you can give the branch name as well which will look like `@Library(‘<name of the library>@<branch name>’) _`
- Groovy scripts under ‘vars’ are used as calling methods (without .groovy extension) inside Jenkinsfile.
- For more information on this, please refer to official Jenkins documentation https://jenkins.io/doc/book/pipeline/shared-libraries/
------------------------------------------------------------------------------------------------------------------------------------------------------------
##How It's Structured
------------------------------------------------------------------------------------------------------------------------
IMPORTANT: **declarative**:declarative[] pipeline scripts (written in Groovy) **must** be placed
in the project's `./vars/` directory in order to be picked up by Jenkins


[ansible-playbooks,bash]

|-commonplaybooks
     - deployment.yml
     - uideploymeny.yml
|-inventoryfiles
     - qataxilla.yml
     - platformqa.yml
     - devtaxilla.yml
|-pemfiles
     - encomply-dev.pem
     - encomplyQA.pem
     - Platfromqa.pem
     - productqa.pem
|-roles       
     - user-deploy
     - mapro-deploy
     - macre-deploy
     - search-deploy
     - taxillaui  
----------------------------------------------------------------------------------------------------------------------        
[source,bash]
-------------------------------------------------------------------------------------------------------------------------
|-pipeline.properties
|-src
|---com
|-----taxilla
|-------jenkins
|---------components/
   - Constants.groovy <-- classes (mainly what you put in Jenkinsfile script {} blocks)
|-vars/
   - ansiblePlaybookConfig.groovy
   - cleanOldJars.groovy
   - compileSource.groovy
   - gitCheckOut.groovy
   - sendEmailNotification.groovy
   - sendFailEmailNotification.groovy
   - uploadingToNexusRepo.groovy  <-- declarative pipelines (*.groovy scripts)
--------------------------------------------------------------------------------------------------------------------------------
Basically, there's a unified repository that contains our shared-library stuff and all other repositories
just import this library and call the pipeline function name (in our case it's the file name Ex:-compileSource.groovy ).

---------------------------------------------------------------------------------------------------------------------------------

## Libraries Used In Taxilla CI/CD Process
---------------------------------------------------------------------------------------------------------------------------------
[gitCheckout.groovy]
Used to clone bitbucket source code. This library accepts 3 below parameters. 
bitbucket GIT URL and branch name. 
Optionally you can supply another parameter to clone the bitbucket repo to a specific folder.
 **Usage On Jenkins files:**
   
    - gitCheckout(ScmURL,BranchName,DirName){
     }
---------------------------------------------------------------------------------------------------------------------------------
[compileSource.groovy]
Used to do gradle and maven compilation of the source code. 
This library accepts 3 parameters, Project Name,Maven and gradle builds parameters.
 **Usage On Jenkins files:**

    - compileSource(PROJECT_NAME, GRADLE_MAVEN_NPM_BUILD_COMMAND,  BUILD_TOOL){
      }
---------------------------------------------------------------------------------------------------------------------------------
[cleanOldJars.groovy]
 used to clean taxilla build machine .gradle old Jras files, no parameters passing from the Jenkins file
   **Usage On Jenkins files:**

    - cleanOldJars(){
      }
---------------------------------------------------------------------------------------------------------------------------------       
[sendEmailNotification.groovy]
it's used for sending email notification to the concerned group about the status of your build/deployment. Based on whether an application done or not, this library supports for 3 parameters.
  **Usage On Jenkins files:**

    - sendEmailNotification('EmailRecipientslist', 'ProjectName',Repo_Name){
      }
---------------------------------------------------------------------------------------------------------------------------------       
[uploadingToNexusRepo.groovy]
 used for uploading binaries to nexus repositories based on environment and this library supports 3 parameters.  
  **Usage On Jenkins files:**   
    
    - uploadingToNexusRepo(ENVIRONMENT_TYPE, CLASSIFIER, VERSION_TYPE, PROJECT_NAME,SRC_ZIP_PATH){
      }
---------------------------------------------------------------------------------------------------------------------------------      
[ansiblePlaybookConfig.groovy]
used to call Ansible playbook environment wise and this library accepts 3 parameters
 **Usage On Jenkins files:**
    
      - ansiblePlaybookConfig(String ENV_TYPE, String TAG, String LIMIT){
      }           
---------------------------------------------------------------------------------------------------------------------------------
  
     
##Jenkins Git Clone Url to checkout source code from bitbucket repository.
[git clone https://taxillasupport@bitbucket.org/taxilla/taxilla-jenkins-shared-library.git]

     
     
                                     /**
                                      * @created 04/12/2020- 23:11:40
                                      * @author Ganesh Mekala
                                     */     
