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
        string(name: 'DEPLOY_ENV', defaultValue: 'production', description: 'Deployment environment')
        string(name: 'RECIPIENT_EMAILS', defaultValue: 'vkavalipurapu@taxilla.com,gmekala@taxilla.com', description: 'Recipient email address')	
	 string(name: 'REPORTS_PATH', defaultValue: 'C:/Users/nbobbili/Downloads/Build reports', description: 'Path to reports')
		
	}
	environment {
		jfrog_CLI_home=tool 'Jfrog_CLI'
	
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
                    def server = 'https://taxilla.jfrog.io/artifactory'
                    def repo = 'jfrog_repo-generic-local'
                    def user = 'niharikabobbili03@gmail.com'
                    def apiKey = 'Taxilla@186'  // or password
                    def artifact = 'my-artifact'
                    def version = '1.0'
                  // Example of uploading a JAR file
                    def fileToUpload = 'C:/Users/nbobbili/Downloads/my-artifact.jar.zip'
                    // Execute the JFrog CLI command to upload the artifact
                    def command=  """${jfrog_CLI_home}\\jf rt u ${fileToUpload} ${repo}/ --url=${server} --user=${user} --password=${apiKey} --build-name=my-build --build-number=1"""
                bat command
		}
            }
        }
	    stage('Post-Deployment') {
            steps {
            def recipients = params.RECIPIENT_EMAIL.split(',').join(',')
                emailext(
                    subject: "Deployment Notification - ${params.DEPLOY_ENV}",
                    body: "Deployment successful. Please find attached reports.",
                    to: recipients,
		    attachLog: true,
                    attachmentsPattern: '**/${params.REPORTS_PATH}/*.txt'
                )
            }
        }
    }	
	post {
        success {
            echo 'Artifact uploaded successfully to Artifactory!'
        }
    }

     }	
