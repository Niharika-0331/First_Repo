def call(){
checkout([
$class: 'GitSCM'
branches: [[name: 'dev2']], 
 userRemoteConfigs: [[url: "https://github.com/hnimmagadda1/Task.git"]]
])
}
