@Library ('First_Repo')_
pipeline{
    agent any
	tools{
		gradle('8.4')
	}
	
	parameters	{
        string(name :'branch', defaultValue: 'main')
	string(name :'url', defaultValue: 'https://github.com/Niharika-0331/First_Repo.git')
	}
	environment {
        // Set your Artifactory details
        ARTIFACTORY_URL = 'https://taxilla.jfrog.io/'
        ARTIFACTORY_REPO = 'result'
        ARTIFACTORY_USERNAME = 'niharikabobbili03@gmail.com'
        ARTIFACTORY_PASSWORD = credentials('Taxilla@186')
        
        // Set your artifact details
        ARTIFACT_PATH = 'C:/my-artifact/my-artifact.jar'
        TARGET_REPO_PATH = 'C:/jfrog/artifactory-pro-7.71.5/app/bin/result'
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
            steps {
                script {
                    // Use Artifactory Maven or Gradle plugin or curl command to upload artifact
                    withCredentials([usernamePassword(credentialsId: ARTIFACTORY_PASSWORD, usernameVariable: 'ARTIFACTORY_USERNAME', passwordVariable: 'ARTIFACTORY_PASSWORD')]) 
									{
                        bat """
                            curl -u ${ARTIFACTORY_USERNAME}:${ARTIFACTORY_PASSWORD} -T ${ARTIFACT_PATH} ${ARTIFACTORY_URL}/${ARTIFACTORY_REPO}/${TARGET_REPO_PATH}/
                        """
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
	
	

