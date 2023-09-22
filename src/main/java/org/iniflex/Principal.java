package org.iniflex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {

        // Item 3.1
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        listaFuncionarios.add(new Funcionario("Maria", LocalDate.parse("18/10/2000", formatoData), new BigDecimal("2009.44"), "Operador"));
        listaFuncionarios.add(new Funcionario("João", LocalDate.parse("12/05/1990", formatoData), new BigDecimal("2284.38"), "Operador"));
        listaFuncionarios.add(new Funcionario("Caio", LocalDate.parse("02/05/1961", formatoData), new BigDecimal("9836.14"), "Coordenador"));
        listaFuncionarios.add(new Funcionario("Miguel", LocalDate.parse("14/10/1988", formatoData), new BigDecimal("19119.88"), "Diretor"));
        listaFuncionarios.add(new Funcionario("Alice", LocalDate.parse("05/01/1995", formatoData), new BigDecimal("2234.68"), "Recepcionista"));
        listaFuncionarios.add(new Funcionario("Heitor", LocalDate.parse("19/11/1999", formatoData), new BigDecimal("1582.72"), "Operador"));
        listaFuncionarios.add(new Funcionario("Arthur", LocalDate.parse("31/03/1993", formatoData), new BigDecimal("4071.84"), "Contador"));
        listaFuncionarios.add(new Funcionario("Laura", LocalDate.parse("08/07/1994", formatoData), new BigDecimal("3017.45"), "Gerente"));
        listaFuncionarios.add(new Funcionario("Heloísa", LocalDate.parse("24/05/2003", formatoData), new BigDecimal("1606.85"), "Eletricista"));
        listaFuncionarios.add(new Funcionario("Helena", LocalDate.parse("02/09/1996", formatoData), new BigDecimal("2799.93"), "Gerente"));

        // Item 3.2
        listaFuncionarios.removeIf(funcionario -> "João".equals(funcionario.getNome()));

        // Item 3.4
        for (Funcionario funcionario : listaFuncionarios) {
            BigDecimal salarioAtual = funcionario.getSalario();
            BigDecimal aumento = salarioAtual.multiply(new BigDecimal("0.10")); // 10% do salário atual
            BigDecimal novoSalario = salarioAtual.add(aumento);

            novoSalario = novoSalario.setScale(2, RoundingMode.HALF_UP);

            funcionario.setSalario(novoSalario); // Novo salário
        }

        // Item 3.3
        NumberFormat formatadorNumerico = NumberFormat.getInstance(new Locale("pt", "BR"));

//        for (Funcionario funcionario : listaFuncionarios) {
//            System.out.println("Nome: " + funcionario.getNome());
//            System.out.println("Data de Nascimento: " + funcionario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//            System.out.println("Salário: " + formatadorNumerico.format(funcionario.getSalario()));
//            System.out.println("Função: " + funcionario.getFuncao());
//            System.out.println("------------------------");
//        }

        // Item 3.5
        Map<String, List<Funcionario>> funcionariosPorFuncao = listaFuncionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // Item 3.6
//        for (Map.Entry<String, List<Funcionario>> entrada : funcionariosPorFuncao.entrySet()) {
//            System.out.println("Função: " + entrada.getKey());
//            for (Funcionario funcionario : entrada.getValue()) {
//                System.out.println("    Nome: " + funcionario.getNome());
//                System.out.println("    Salário: " + formatadorNumerico.format(funcionario.getSalario()));
//                System.out.println("    -----------------");
//            }
//        }

        // Item 3.8
//        System.out.println("Funcionários que fazem aniversário nos meses 10 e 12:");
//        for (Funcionario funcionario : listaFuncionarios) {
//            int mesAniversario = funcionario.getDataNascimento().getMonthValue();
//            if (mesAniversario == 10 || mesAniversario == 12) {
//                System.out.println("    Nome: " + funcionario.getNome());
//                System.out.println("    Mês de Aniversário: " + mesAniversario);
//                System.out.println("    -----------------");
//            }
//        }

        // Item 3.9
//        Funcionario funcionarioMaisVelho = listaFuncionarios.stream()
//                .min((f1, f2) -> f1.getDataNascimento().compareTo(f2.getDataNascimento()))
//                .orElse(null);
//
//        if (funcionarioMaisVelho != null) {
//            int idade = Period.between(funcionarioMaisVelho.getDataNascimento(), LocalDate.now()).getYears();
//            System.out.println("Funcionário com a maior idade:");
//            System.out.println("    Nome: " + funcionarioMaisVelho.getNome());
//            System.out.println("    Idade: " + idade);
//        } else {
//            System.out.println("Não há funcionários na lista.");
//        }

        // Item 3.10
//        List<Funcionario> funcionariosOrdenados = listaFuncionarios.stream()
//                .sorted((f1, f2) -> f1.getNome().compareTo(f2.getNome()))
//                .collect(Collectors.toList());
//
//        System.out.println("Lista de funcionários por ordem alfabética:");
//        for (Funcionario funcionario : funcionariosOrdenados) {
//            System.out.println("    Nome: " + funcionario.getNome());
//        }

        // Item 3.11
//        BigDecimal totalSalarios = listaFuncionarios.stream()
//                .map(Funcionario::getSalario)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//        System.out.println("Total dos salários dos funcionários: " + formatadorNumerico.format(totalSalarios));

        // Item 3.12
        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        System.out.println("Quantos salários mínimos cada funcionário ganha:");
        for (Funcionario funcionario : listaFuncionarios) {
            BigDecimal salario = funcionario.getSalario();
            BigDecimal qtdSalariosMinimos = salario.divide(salarioMinimo, 2, RoundingMode.HALF_UP);

            System.out.println("    Nome: " + funcionario.getNome());
            System.out.println("    Salários mínimos: " + qtdSalariosMinimos);
            System.out.println("    -----------------");
        }
    }
}


