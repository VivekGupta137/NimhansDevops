pipeline {
   agent any

   stages {
      stage('welcome') {
         steps {
            echo 'This code is maintained by Vivek Gupta'
         }
      }
//   stage to pull from github private repository
      stage('github'){
          steps {
              echo 'cloning the NimhansDevops repository'
              git branch: 'master',
                credentialsId: 'git_nimhansdevops',
                url: 'git@github.com:VivekGupta137/NimhansDevops.git'
              sh "ls -lat"
          }
      }
      stage('building containers'){
          steps{
              sh "sudo docker-compose push"
          }
      }
   }
//    all stages completed now add post build options
   post {
       success {
            // echo "stopping sql service forwarding this task to rundeck"
            // sh "docker-compose down"
            
            echo 'sending success the notification to rundeck'
            build job: 'rundeck'
       }
   }
}
