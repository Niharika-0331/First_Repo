@Library ('First_Repo')_
pipeline{
    agent any
	tools{
		gradle('2.9')
	}
	
	parameters	{
        string(name :'branch', defaultValue: 'main')
	string(name :'url', defaultValue: 'https://github.com/Niharika-0331/First_Repo.git')
	}
	
    stages {
        stage('Git Checkout') {
            steps {
            script{
            checkout_script(params)
            }
            }
			}
        
         }
	
	 stage('Build') {
            steps {
                script {
                    // Run Gradle build command
                    sh './gradlew clean'
                }
            }
        }
}
