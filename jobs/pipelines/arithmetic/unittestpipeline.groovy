def runTests() {
    pipeline {
        agent any

        stages {
            stage('Unit Test') {
                steps {
                    script {
                        def result = arithmeticPipeline('add', 2, 3)
                        echo "Test Result: ${result}"
                        
                        // Generate JUnit report
                        def junitReport = """
                        <testsuite name='ArithmeticTests'>
                            <testcase name='Addition Test'>
                                ${result == 5 ? "" : "<failure message='Expected 5 but got ${result}'/>"}
                                <system-out>
                                    <![CDATA[ 2 + 3 = ${result} ]]>
                                </system-out>
                            </testcase>
                        </testsuite>
                        """
                        writeFile file: 'addition-test.xml', text: junitReport
                    }
                }
            }

            stage('Publish Test Results') {
                steps {
                    junit '**/*.xml'
                }
            }
        }
    }
}
