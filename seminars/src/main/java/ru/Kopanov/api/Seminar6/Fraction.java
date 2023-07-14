package ru.Kopanov.api.Seminar6;

import java.util.Objects;

public class Fraction {
    private int numerator;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator){
        this.numerator = numerator;
    }

    public int getDenominator() {

        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0){
            throw new RuntimeException("Знаменатель не может быть равен 0");
        }
        this.denominator = denominator;
    }

    public Fraction plus( Fraction f2){
        int den = denominator == f2.denominator ? denominator : denominator * f2.denominator;
        int num = denominator == f2.denominator ? numerator + f2.numerator :
                f2.numerator* denominator + f2.denominator * numerator;
        return new Fraction(num, den);
    }

    public static Fraction plus(Fraction f1, Fraction f2){
        int den = f1.denominator == f2.denominator ? f1.denominator : f1.denominator * f2.denominator;
        int num = f1.denominator == f2.denominator ? f1.numerator + f2.numerator :
                f2.numerator* f1.denominator + f2.denominator * f1.numerator;
        return new Fraction(num, den);
    }

    public Fraction(){
        numerator = 1;
        denominator = 1;
    }
    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        if (denominator == 0){
            throw new RuntimeException("Знаменатель не может быть равен 0");
        }
            this.denominator = denominator;

    }

    @Override
    public String toString() {
        return String.format("%d/%d", numerator, denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
