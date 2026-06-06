pipeline {

    agent any

    stages {


stage('Checkout') {
    steps {
        git url: 'https://github.com/tuusuario/reto4.git'
    }
}
        stage('Selenium Tests') {

            steps {

                dir('reto4-selenium') {

                    bat 'mvn clean test'

                }

            }

            post {

                always {

                    archiveArtifacts artifacts: 'reto4-selenium/screenshots/**/*.*', allowEmptyArchive: true

                    archiveArtifacts artifacts: 'reto4-selenium/reports/**/*.*', allowEmptyArchive: true

                }

            }

        }

        stage('Cypress Tests') {

            steps {

                dir('reto4-cypress') {

                    bat 'npx cypress run'

                }

            }

            post {

                always {

                    archiveArtifacts artifacts: 'reto4-cypress/cypress/screenshots/**/*.*', allowEmptyArchive: true

                    archiveArtifacts artifacts: 'reto4-cypress/cypress/videos/**/*.*', allowEmptyArchive: true

                    archiveArtifacts artifacts: 'reto4-cypress/cypress/reports/**/*.*', allowEmptyArchive: true

                }

            }

        }

    }

}