pipeline {
    agent any

    stages {
        stage('Build and Test') {
            steps {
                script {
                    // Checkout code
                    checkout scm

                    // Set up Python environment
                    sh 'python3 -m venv venv'
                    sh 'source venv/bin/activate'

                    // Install dependencies
                    sh 'python -m pip install --upgrade pip'
                    sh 'pip install -r requirements.txt'

                    // Run Tests
                    sh 'python manage.py test'
                }
            }
        }
    }
}

