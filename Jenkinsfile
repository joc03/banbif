/* Only keep the 10 most recent builds. */
def projectProperties = [
    [$class: 'BuildDiscarderProperty',strategy: [$class: 'LogRotator', numToKeepStr: '5']],
]
podTemplate(label: "maven",
  cloud: "openshift",
  inheritFrom: "maven") {
    node("maven") {

        def namespace = "fuse"

        stage('Clone repository') {
            checkout scm
        }

        if (env.BRANCH_NAME == "develop") {

            stage('Pruebas Automatizadas') {
                script {
                    try {
                        sh "./gradlew clean test aggregate"
                    }
                    catch (ex) {
                        echo 'Test Ejecutados con Fallo'
                    }
                }
            }
            
            deployFabric8(
                ambiente : 'dev',
                namespace : "${namespace}"
            )
            
        }
    }
}