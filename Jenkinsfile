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
        }
    }

    post {

    always {

        allure([
            includeProperties: false,
            jdk: '',
            results: [
                [path: 'reto4-selenium/allure-results'],
                [path: 'reto4-cypress/allure-results']
            ]
        ])

        archiveArtifacts artifacts: '**/allure-results/**', allowEmptyArchive: true

        echo "RESULTADO FINAL DEL BUILD: ${currentBuild.currentResult}"
    }

    success {
        echo '✅ Todas las pruebas pasaron correctamente.'
    }

    unstable {
        echo '⚠️ Existen pruebas fallidas pero se generó el reporte.'
    }

    failure {
        echo '❌ Algunas pruebas fallaron. Revisar Allure Report.'
    }
}
}
