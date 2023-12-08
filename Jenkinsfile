@Library ('First_Repo')_
pipeline{
    agent any
	
    stages {
	     stage('Debug') {
            steps {
                script {
                    echo "Loading First_Repo library..."
                    def myLibrary = library('First_Repo')
                    echo "Library contents: ${myLibrary}"
                }
            }
        }
        stage('Git Checkout') {
            steps {
            script{
            checkout_script(params)
            }
            }
			}
	
	 
    }
    	
}
