def call()
checkout([
$class: 'GitSCM'
branches: [[name: 'main']], 
 userRemoteConfigs: [[url: "https://github.com/Niharika-0331/First_Repo.git"]]
])
