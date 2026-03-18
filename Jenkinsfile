pipeline {
    agent any

    triggers {
        githubPush()
    }

    stages {

        stage('Build & Run Tests') {
            steps {
                bat 'mvn clean test -Dmaven.test.failure.ignore=true'
            }
        }

        stage('Publish Test Reports') {
            steps {
                junit 'target/cucumber.xml'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'target/**', fingerprint: true
            }
        }
    }

    post {
        always {
            emailext (
                subject: "Build: ${env.JOB_NAME} #${env.BUILD_NUMBER} - ${currentBuild.currentResult}",
                body: """
Build Status: ${currentBuild.currentResult}

Job: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}

View Report: ${env.BUILD_URL}

""",
                to: "ashwinigmeet@gmail.com"
            )
        }
    }
}