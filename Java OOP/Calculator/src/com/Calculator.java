package com;

public class Calculator {
    private double operandOne = 0.0;
    private String operation = "";
    private double operandTwo = 0.0;
    private double mathTotal = 0.0;

    public Calculator() {

    }

    public Calculator(double operandOne, String operation, double operandTwo) {
        this.operandOne = operandOne;
        this.operandTwo = operandTwo;
        this.operation = operation;
    }

    public Double getOperandOne() {
        return operandOne;
    }

    public Double getOperandTwo() {
        return operandTwo;
    }

    public Double getMathTotal() {
        return mathTotal;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperandOne(Double operandOne) {
        this.operandOne = operandOne;
    }

    public void setOperandTwo(Double operandTwo) {
        this.operandTwo = operandTwo;
    }

    public void setMathTotal(Double mathTotal) {
        this.mathTotal = mathTotal;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void performOperation() {
        if (getOperation().equals("+")) {
            Double total = getOperandOne() + getOperandTwo();
            setMathTotal(total);
        } else if (getOperation().equals("-")) {
            Double total = getOperandOne() - getOperandTwo();
            setMathTotal(total);
        }
    }

    public void getResults() {
        System.out.println(getMathTotal());
    }
}
