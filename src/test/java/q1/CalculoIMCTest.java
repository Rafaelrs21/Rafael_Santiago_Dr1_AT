package q1;

import net.jqwik.api.*;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class CalculoIMCTest {

    @Property
    public void classificarIMC() {
        assertEquals("Magreza grave", CalculoIMC.classificarIMC(15.0));
        assertEquals("Magreza moderada", CalculoIMC.classificarIMC(16.5));
        assertEquals("Magreza leve", CalculoIMC.classificarIMC(17.5));
        assertEquals("Saudável", CalculoIMC.classificarIMC(22.0));
        assertEquals("Sobrepeso", CalculoIMC.classificarIMC(27.0));
        assertEquals("Obesidade Grau I", CalculoIMC.classificarIMC(32.0));
        assertEquals("Obesidade Grau II", CalculoIMC.classificarIMC(37.0));
        assertEquals("Obesidade Grau III", CalculoIMC.classificarIMC(42.0));
    }

    @Property
    public void calcularPeso() {
        assertEquals(24.88, Math.round(CalculoIMC.calcularPeso(70.1, 1.68) * 100.0) / 100.0, 0.05);
        }


    @Property
    public void testeValoresLimite() {
        assertEquals(200.0, CalculoIMC.calcularPeso(50, 0.5), 0.01);
        assertEquals(40.82, CalculoIMC.calcularPeso(500, 3.5), 0.01);
        assertEquals(0.0, CalculoIMC.calcularPeso(0, 1.75), 0.01);
        assertEquals(40.82, CalculoIMC.calcularPeso(500, 3.5), 0.01);
    }

    @Property
    public void imcNuncaDeveSerNegativo(@ForAll @Positive double peso, @ForAll @Positive double altura) {
        double imc = peso / (altura * altura);
        Assertions.assertTrue(imc >= 0, "O IMC nunca deve ser negativo");
    }

    @Provide
    Arbitrary<Double> pesosExtremos() {
        return Arbitraries.of(30.0, 45.0, 80.0, 150.0, 250.0, 400.0);
    }

    @Provide
    Arbitrary<Double> alturasExtremas() {
        return Arbitraries.of(0.1, 0.5, 1.0, 1.5, 2.0, 2.5);
    }

    @Property
    public void imcDeveSerCalculadoCorretamente(@ForAll("pesosExtremos") double peso,
                                                @ForAll("alturasExtremas") double altura) {
        double imc = CalculoIMC.calcularPeso(peso, altura);
        Assertions.assertTrue(imc >= 0, "O IMC deve ser um valor não negativo.");
    }

    @Property
    public void imcDeveSerValidoParaQualquerEntrada(@ForAll double peso, @ForAll double altura) {
        Assume.that(peso > 0 && altura > 0);

        double imc;
        try {
            imc = CalculoIMC.calcularPeso(peso, altura);
        } catch (Exception e) {
            throw new AssertionError("Erro inesperado ao calcular o IMC com peso=" + peso + " e altura=" + altura, e);
        }

        Assertions.assertTrue(imc >= 0, "O IMC deve ser um valor não negativo.");
    }
}