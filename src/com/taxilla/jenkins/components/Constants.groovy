package com.taxilla.jenkins.components

class Constants {
    //Jenkins Custom workSpace Location
    static final CUSTOM_WORKSPACE = '/home/buildtool/customworkspace/'
    //Bit Bucket Credential's ID
    static final BITBUCKET_CREDENTIAIL_ID = 'e2150e6f-1b1d-4f3b-8766-226ba9653e5c'
    static final BITBUCKET_CREDENTIAIL_ID1 ='4fbd8dd9-3510-445e-941c-41cc13243480'

    // Nexus Commons properties
    static final NEXUS_REPOSITORY_URL = 'nexus.taxilla.com'
    static final NEXUS_CREDENTIAIL_ID = 'nexus_3'
    static final NEXUS_VERSION = 'nexus3'
    static final PROTOCOL_TYPE = 'https'
    static final REPOSITORY_QA = 'taxilla-qa-releases'
    static final REPOSITORY_PROD = 'taxilla-production-releases'

    // Nexus environment specific  Group-ID properties
    static final QA_GROUP_ID = 'QA'
    static final PROD_GROUP_ID = 'Taxilla'
    static final ARTIFACT_ID ='prod-release'
    //Nexus Module specific properties


    //Gradle Cache Directories
    static final COM_ADAEQUARE_FOLDER_LOCATION = '/home/buildtool/.gradle/caches/modules-2/files-2.1'
    static final DESCRIPTORS_JAR_FILES_LOCATION = '/home/buildtool/.gradle/caches/modules-2/metadata-2.96/descriptors'

    //Build Tools
    static final GRADLE_VERSION = 'gradle6.0'
    static final JDK11_VERSION = 'OPENJDK-11.0.7'
    static final MAVEN_HOME = 'Maven'

    // Taxilla Modules Compilation locations
    static final ETL_COMPILE_LOCATION = '/etl-clover'
    static final MACRE_COMPILE_LOCATION = '/MACre_Release_2.0.0'
    static final PROPERTY_LOADER_COMPILE_LOCATION = '/property-loader'

    //Taxilla Build Binaries Paths
    static final GSP_QA = '/target/qa'
    static final GSP_UAT = '/target/uat/adaequare'
    static final ETL_BINARIES_PATH = '/build/libs/'
    static final MACRE_BINARIES_PATH = '/macre-app/build/libs'
    static final TAXILLA_BINARIES_PATH = '/webapp/build/distributions'
    static final SEARCH_BINARIES_PATH = '/search-rest-api/build/distributions'
    static final USER_BINARIES_PATH = '/server/build/distributions'
    static final GMAP_UTILS_PATH = '/application/build/distributions'
    static final ENINVOICE_BACKEND_PATH = '/build/distributions'
    static final PROPERTY_LOADER_PATH = '/property-loader/build/libs'
    static final FVU_PATH = '/fvu-reports/build/libs/'
    static final ADDTAX_PATH = '/addtax-service/build/distributions'
    static final UI_PATH = '/dist'

    //Taxilla Modules WAR,JAR and Zip Wise File Names
    static final ETL = 'etl.war'
    static final ETL_ZIP = 'etl.zip'
    static final USER_ZIP = 'user.zip'
    static final TAXILLA_ZIP = 'taxilla.zip'
    static final VDM_ZIP='vdm.zip'
    static final VDM_WAR='vdm.war'
    static final SEARCH_ZIP = 'search.zip'
    static final ENINVOICE_ZIP = 'eninvoice.zip'
    static final APPLICATION_ZIP = 'application.zip'
    static final ADDTAX_ZIP = 'addtax.zip'
    static final FVU_ZIP = 'fvu.zip'
    static final FVU_JAR = 'fvu.jar'
    static final PROPERTY_LOADER_JAR = 'property-loader.jar'
    static final PROPERTY_LOADER = 'property-loader.zip'
    static final MACREUI_NAME = 'macre-frontend'
    static final MACEUI_ZIP = 'macreui.zip'
    static final TAXILLA_UI_FOLDER = 'taxilla-ui'
    static final TAXILLA_UI_ZIP = 'taxilla-ui.zip'

    static final ENCOMPLY_UI_ZIP = 'encomply-ui.zip'
    static final ENREPORT_UI_ZIP = 'encomply-ui.zip'
    static final ENINVOICE_UI_ZIP = 'encomply-ui.zip'
    static final MACRE_UI_ZIP = 'encomply-ui.zip'
    static final ROOT = 'ROOT.war'
    static final ROOT_ZIP = 'ROOT.zip'
    static final GSTWRAPPER_ZIP = 'gstwrapper.zip'
    static final GSTWRAPPER = 'gstwrapper.war'
    static final GSPUI = 'gspui'

    //JumpHost Key files for qataxilla
    static final ANSIBLE_COMMON_PATH = '/home/buildtool/taxilla-jenkins-shared-library'
    static final QATAXILLA_KEYFILE = 'taxilla-build-machine.pem'
    static final QATAXILLA_JUMPBOX = '54.226.197.196'
    static final QATAXILLA_INVENTORY_FILE = 'ansible-playbook -i inventoryfiles/qataxilla.yml'
    //platformqa
    static final PLATFORMQA_KEYFILE = 'taxilla-build-machine.pem'
    static final PLATFORMQA_JUMPBOX = '54.226.197.196'
    static final PLATFORMQA_INVENTORY_FILE = 'ansible-playbook -i inventoryfiles/platform.yml'
    //devtaxilla
    static final DEVTAXILLA_KEYFILE = 'product-qa.pem'
    static final DEVTAXILLA_JUMPBOX = '15.207.152.11'
    static final DEVTAXILLA_INVENTORY_FILE = 'ansible-playbook -i inventoryfiles/productqa.yml'
    //devtaxilla
    static final ASSETQA_KEYFILE = 'encomply-dev.pem'
    static final ASSETQA_JUMPBOX = '23.20.63.114'
    static final ASSETQA_INVENTORY_FILE = 'ansible-playbook -i inventoryfiles/productqa.yml'
}
