pipeline {
    agent any

    triggers {
        githubPush()
    }

    stages {
        stage('Checkout SCM') {
            steps {
                git url: 'https://github.com/Ashwini-ashu123/All-WareHouse.git', branch: 'master'
            }
        }

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
}
post {
        success {
            mail to: 'aswini.p@rudhrainfosolutions.com',
            subject: "Jenkins Build Successful",
            body: "Your Jenkins pipeline has completed successfully."
        }
        failure {
            mail to: 'aswini.p@rudhrainfosolutions.com',
            subject: "Jenkins Build Failed",
            body: "Your Jenkins pipeline has failed. Please check the logs."
        }
    }
}
