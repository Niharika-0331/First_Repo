@Library ('First_Repo')_
pipeline{
    agent any
	
	parameters	{
        string(name :'branch', defaultValue: 'main')
	string(name :'url', defaultValue: 'https://github.com/Niharika-0331/First_Repo.git')
	}
	
    stages {
        stage('Git Checkout') {
            steps {
            script{
            checkout_script()

            }
            }
			}
        
         }
}
