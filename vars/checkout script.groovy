
    def gitUrl = 'https://github.com/Niharika-0331/First_Repo'
    def localDir = "C:\\Users\\nbobbili\\Downloads\\Checkout\\"
    def branch = 'main'


// Clone the repository
    def cloneCommand = "git clone ${gitUrl}"
    println "Executing: ${cloneCommand}"
    def cloneProcess = cloneCommand.execute()
    cloneProcess.waitFor()

// Change directory to the cloned repository
    def repoDir = new File(localDir)
    println "Changing directory to: ${repoDir}"

    repoDir.with {

// Checkout the specified branch
        def checkoutCommand = "git checkout ${branch}"
        println "Executing: ${checkoutCommand}"
        def checkoutProcess = checkoutCommand.execute()
        checkoutProcess.waitFor()



    }

