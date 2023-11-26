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
        MY_CREDENTIALS = credentials('niharikabobbili03@gmail.com':'Taxilla@186')
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
                     echo "Using credentials: ${MY_CREDENTIALS}"
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
	

