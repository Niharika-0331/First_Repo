@Library ('First_Repo')_
pipeline{
    agent any
	tools{
		gradle('8.4')
		jfrog'Jfrog_CLI'
		
	}
	
	parameters	{
        string(name :'branch', defaultValue: 'main')
	string(name :'url', defaultValue: 'https://github.com/Niharika-0331/First_Repo.git')
	}
	  environment {
        ARTIFACTORY_SERVER_ID = 'jfrog_instance'
        REPO = 'result'
        ARTIFACT = 'my-artifact'
        VERSION = '1.0'
        FILE_TO_UPLOAD = ""C:/Users/nbobbili/Downloads/${ARTIFACT}-${VERSION}.jar"
    }
	
    stages {
        stage('Git Checkout') {
            steps {
            script{
            checkout_script(params)
            }
            }
			}
	     stage('Build') {
            steps {
                script {
                    // Run Gradle build command
                    bat 'gradle build'
                }
            }
        }
	    
 stage('Upload to Artifactory') {

        stage('Upload to Artifactory') {
            steps {
                script {
                    withCredentials([string(credentialsId: env.ARTIFACTORY_SERVER_ID, variable: 'Credentials')]) {
                        bat "jfrog rt u ${FILE_TO_UPLOAD} ${REPO}/${ARTIFACT}/${VERSION}/${ARTIFACT}-${VERSION}.jar --url=${ARTIFACTORY_SERVER} --user=${ARTIFACTORY_SERVER_CREDENTIALS_USR} --apikey=${ARTIFACTORY_SERVER_CREDENTIALS_PSW} --build-name=my-build --build-number=1"
                    }
                }
            }
        }
    }
}
        }
    }
	
	post {
        success {
            echo 'Artifact uploaded successfully to Artifactory!'
        }
    }

     }	
	

