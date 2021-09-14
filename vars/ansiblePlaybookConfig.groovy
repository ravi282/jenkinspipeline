/**
 * @created 17/11/2020- 20:35
 * @author gmekala* @project taxilla-jenkins-shared-library
 */
import static com.taxilla.jenkins.components.Constants.*

def call(String ENV_TYPE, String TAG, String LIMIT) {
    if (ENV_TYPE.contains("qataxilla")) {
        sh "chmod 600 pemfiles/$QATAXILLA_KEYFILE"
        sh "cd $ANSIBLE_COMMON_PATH && $QATAXILLA_INVENTORY_FILE commonplaybooks/deployment.yml --tags '$TAG' --limit=$LIMIT"
        //String test = etl = sh(returnStatus: true, script: "ssh -o StrictHostKeyChecking=no -i pemfiles/$QATAXILLA_KEYFILE centos@$QATAXILLA_JUMPBOX \"cd $ANSIBLE_COMMON_PATH && ansible -i inventoryfiles/$QATAXILLA_INVENTORY_FILE -m shell -a 'df -hT' mapro \"")
    } else if (ENV_TYPE.contains("platformqa")) {
        sh "chmod 600 pemfiles/$PLATFORMQA_KEYFILE"
        sh "cd $ANSIBLE_COMMON_PATH && $PLATFORMQA_INVENTORY_FILE commonplaybooks/deployment.yml --tags '$TAG' --limit=$LIMIT "

    } else if (ENV_TYPE.contains("devtaxilla")) {
        sh "chmod 600 pemfiles/$DEVTAXILLA_KEYFILE"
        sh "cd $ANSIBLE_COMMON_PATH && $DEVTAXILLA_INVENTORY_FILE commonplaybooks/deployment.yml --tags '$TAG' --limit=$LIMIT  "

    } else if (ENV_TYPE.contains("assetqa")) {
        sh "chmod 600 pemfiles/$ASSETQA_KEYFILE"
        sh "cd $ANSIBLE_COMMON_PATH && $ASSETQA_INVENTORY_FILE commonplaybooks/deployment.yml --tags '$TAG' --limit=$LIMIT"

    } else if (ENV_TYPE.contains("test")) {
        sh "chmod 600 pemfiles/$ASSETQA_KEYFILE"
        sh "ssh -o StrictHostKeyChecking=no -i pemfiles/$ASSETQA_KEYFILE centos@$ASSETQA_JUMPBOX \"cd $ANSIBLE_COMMON_PATH && $ASSETQA_INVENTORY_FILE commonplaybooks/deployment.yml --tags '$TAG' --limit=$LIMIT  \""


    } else if (ENV_TYPE.contains("kpmgprod")) {
        
    }

}

