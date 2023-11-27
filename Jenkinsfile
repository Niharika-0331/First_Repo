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
                    def server = 'https://taxilla.jfrog.io/'
                    def repo = 'result'
                    def user = 'niharikabobbili03@gmail.com'
                    def apiKey = 'Taxilla@186'  // or password

                    // Replace 'your-artifact' and 'your-version' with your actual artifact details
                    def artifact = 'my-artifact'
                    def version = '1.0'

                    // Example of uploading a JAR file
                    def fileToUpload = 'C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\Pipeline_demo\\my-artifact.jar'

                    // Execute the JFrog CLI command to upload the artifact

                    def command=  """${jfrog_CLI_home}\\jfrog rt u ${fileToUpload} ${repo}/${artifact}/${version} --url=${server} --user=${user} --apikey=${apiKey} --build-name=my-build --build-number=1"""
                bat command
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
	

