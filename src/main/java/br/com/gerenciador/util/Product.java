package br.com.gerenciador.util;


public class Product {

    private String name;
    private int number1;
    private int number2;

    public Product() {
        //
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(Product other) {
        number1 = other.number1;
        number2 = other.number2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

	@Override
	public String toString() {
		return "Product [name=" + name + ", number1=" + number1 + ", number2=" + number2 + "]";
	}
    
    

}