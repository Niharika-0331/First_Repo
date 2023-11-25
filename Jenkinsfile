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
        PATH_TO_JFROG_CLI = "C:\\jfrog\\artifactory-oss-7.71.5\\app\\bin"
        ARTIFACTORY_USER = 'admin'
        ARTIFACTORY_API_KEY = 'Taxilla@186'
        ARTIFACTORY_REPO_URL = 'https://62e8-49-37-152-163.ngrok-free.app/artifactory/Jfrogrepo/'
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
	   stages {
        stage('Upload to Artifactory') {
            steps {
                script {
                    bat "curl -fL https://62e8-49-37-152-163.ngrok-free.app | sh"
                    bat "set PATH=%PATH%;${PATH_TO_JFROG_CLI}"

                    withEnv(["PATH+EXTRA=%PATH%;${PATH_TO_JFROG_CLI}"]) {
                        bat "jfrog rt config --url ${ARTIFACTORY_REPO_URL} --user ${ARTIFACTORY_USER} --apikey ${ARTIFACTORY_API_KEY} --interactive=false"
                        bat 'jfrog rt u --spec build-info.json'
    }
	 post {
        success {
            echo 'Artifact uploaded successfully to Artifactory!'
        }
    }

     }	
	

