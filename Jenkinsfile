pipeline {
    agent any

    stages {

        stage('Limpiar workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Clonar repositorio') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/jnvictorq/reto4-automation.git'
            }
        }

        stage('Ejecutar Selenium') {
            steps {
                dir('reto4-selenium') {
                    bat 'mvn clean test'
                }
            }
            post {
                always {
                    archiveArtifacts artifacts: 'reto4-selenium/allure-results/**/*.*', allowEmptyArchive: true
                    archiveArtifacts artifacts: 'reto4-selenium/screenshots/**/*.*', allowEmptyArchive: true
                }
            }
        }

        stage('Instalar dependencias Cypress') {
            steps {
                dir('reto4-cypress') {
                    bat 'npm install'
                }
            }
        }

        stage('Ejecutar Cypress') {
            steps {
                dir('reto4-cypress') {
                    bat 'npx cypress run --env allure=true'
                }
            }
            post {
                always {
                    archiveArtifacts artifacts: 'reto4-cypress/allure-results/**/*.*', allowEmptyArchive: true
                    archiveArtifacts artifacts: 'reto4-cypress/cypress/screenshots/**/*.*', allowEmptyArchive: true
                    archiveArtifacts artifacts: 'reto4-cypress/cypress/videos/**/*.*', allowEmptyArchive: true
                }
            }
        }
        stage('Publicar reporte Allure') {
            steps {
                allure(
                    includeProperties: false,
                    jdk: '',
                    results: [
                        [path: 'reto4-selenium/allure-results'],
                        [path: 'reto4-cypress/allure-results']
                    ]
                )
            }
        }
    }

    post {
        success {
            echo 'Todas las pruebas pasaron correctamente.'
        }

        failure {
            echo 'Algunas pruebas fallaron. Revisar evidencias y reportes.'
        }

        always {
        echo 'Reporte Allure generado.'
        }
    }
}
