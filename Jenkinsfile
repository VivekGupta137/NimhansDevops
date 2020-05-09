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
                credentialsId: 'nimhansdevops',
                url: 'git@github.com:VivekGupta137/NimhansDevops.git'
              sh "ls -lat"
          }
      }
      stage('Sql Service'){
          steps{
              echo 'starting the db service'
              sh "docker-compose up -d db"
              echo "sleeping for 5 seconds"
              sh "sleep 5"
              echo "sql service is running"
          }
      }
   }
//    all stages completed now add post build options
   post {
       success {
            echo "stopping sql service forwarding this task to rundeck"
            sh "docker-compose down"
            echo 'sending success the notification to rundeck'
            build job: 'rundeck'
       }
   }
}
