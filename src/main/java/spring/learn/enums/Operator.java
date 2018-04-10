package spring.learn.enums;

public enum Operator { //编译生成一个抽象类，继承java.lang.enum类,枚举值都是公共静态属性

    ADD("+") {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    },
    SUBTRACT("-") {
        @Override
        public int calculate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int a, int b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int a, int b) {
            if (b == 0) {
                throw new IllegalArgumentException("divisor must not be 0");
            }
            return a / b;
        }
    };

    Operator(String operator) {
        this.operator = operator;
    }

    private String operator;

    public abstract int calculate(int a, int b);

    public String getOperator() {
        return operator;
    }

} 