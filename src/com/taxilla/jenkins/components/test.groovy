package com.taxilla.jenkins.components

import static com.taxilla.jenkins.components.Constants.getQATAXILLA_INVENTORY_FILE
import static com.taxilla.jenkins.components.Constants.getQATAXILLA_JUMPBOX
import static com.taxilla.jenkins.components.Constants.getQATAXILLA_KEYFILE
import static com.taxilla.jenkins.components.Constants.getQATAXILLA_KEYFILE

/**
 * @created 19/11/2020- 21:32
 * @author gmekala* @project taxilla-jenkins-shared-library
 */

class test {
    void main() {
        sh "chmod 600 pemfiles/$QATAXILLA_KEYFILE"
        String test1 = sh(returnStatus: true, script: "ssh -o StrictHostKeyChecking=no -i pemfiles/$QATAXILLA_KEYFILE centos@$QATAXILLA_JUMPBOX \"cd ansible && ansible -i inventory/$QATAXILLA_INVENTORY_FILE -m shell -a 'df -hT' mapro \"")

    }
}
