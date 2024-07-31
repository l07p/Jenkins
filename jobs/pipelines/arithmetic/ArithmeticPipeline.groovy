def arithmeticPipeline(operation, num1, num2) {
    num1 = num1.toInteger()
    num2 = num2.toInteger()
    switch(operation) {
        case 'add':
            return num1 + num2
        case 'subtract':
            return num1 - num2
        case 'multiply':
            return num1 * num2
        case 'divide':
            if (num2 == 0) {
                error("Division by zero is not allowed.")
            }
            return num1 / num2
        default:
            error("Unsupported operation: ${operation}")
    }
}
return this
