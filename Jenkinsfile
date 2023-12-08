@Library ('First_Repo')_
pipeline{
    agent any
	tools{
			gradle('7.3')
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
	 
    }
    	
}
