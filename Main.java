package Banco;

import java.awt.*;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args){
        // main
        Conta conta = new Conta(0, 0, 0, "Tião", "000111222333-44");

        try{
            conta.Depositar(0);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch(InputMismatchException r){
            System.out.println("Favor, digitar um número");
        }

        // janela
        SwingUtilities.invokeLater(() -> {
            // janelas
            JFrame janela = new JFrame("Janela Principal");
            janela.setBounds(10, 10, 600, 300);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setVisible(false);

            JFrame janela2 = new JFrame("Janela Secundária");
            janela2.setBounds(620, 10, 600, 300);
            janela2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela2.setVisible(true);


            // painel 1
            JPanel painel2 = new JPanel(new GridLayout(5, 2, 8, 8));
            painel2.setBackground(Color.CYAN);
            janela2.add(painel2);

            // painel 1
            JPanel painel = new JPanel();
            painel.setBackground(Color.YELLOW);
            janela.add(painel);

            JLabel seuCPF = new JLabel("Seu CPF: ");
            JLabel seuTitular = new JLabel("Seu Nome Completo:");
            JLabel suaConta = new JLabel("Sua Conta: ");
            JLabel suaAgencia = new JLabel("Sua Agência: ");
            JButton botaoDeposito = new JButton("Fazer Depósito");
            JButton botaoSair = new JButton("Sair");
            botaoDeposito.addActionListener(e -> {
                janela.setVisible(true);
                janela2.setVisible(false);
            });
            botaoSair.addActionListener(e -> {
                System.exit(0);
            });
            JTextField digitarCPF = new JTextField(15);
            JButton botaoCPF = new JButton("Confirmar");
            JTextField digitarTitular = new JTextField(15);
            JButton botaoTitular = new JButton("Confirmar");
            JTextField digitarConta = new JTextField(15);
            JButton botaoConta = new JButton("Confirmar");
            JTextField digitarAgencia = new JTextField(15);
            JButton botaoAgencia = new JButton("Confirmar");

            JLabel texto = new JLabel("Olá " + conta.getTitular() + " digite o valor que gostaria de depositar:");
            JTextField digitar = new JTextField(15);
            JButton botao = new JButton("Depositar");

            painel.add(texto);
            painel.add(digitar);
            painel.add(botao);

            painel2.add(seuCPF); //label
            painel2.add(digitarCPF); //textfield
            //painel2.add(new JLabel(conta.getCPF())); //execução
            //painel2.add(botaoCPF);
//            painel2.

            painel2.add(seuTitular); //label
            painel2.add(digitarTitular);
            conta.setTitular(digitarTitular.toString());
//            painel2.add(new JLabel(conta.getTitular()));
//            painel2.add(botaoTitular);

            painel2.add(suaConta);
            painel2.add(digitarConta);
//            painel2.add(new JLabel(String.valueOf(conta.getConta())));
//            painel2.add(botaoConta);

            painel2.add(suaAgencia);
            painel2.add(digitarAgencia);
//            painel2.add(new JLabel(String.valueOf(conta.getAgencia())));
//            painel2.add(botaoAgencia);

            if(digitarTitular.getText().isEmpty()){
                System.out.println("Titular vazio");
            }

            //fazer um pra cada

            painel2.add(botaoDeposito);
            painel2.add(botaoSair);

            //botão

            botao.addActionListener(e -> {
                try{
                    double valor = Double.parseDouble(digitar.getText());
                    conta.Depositar(valor);
                    texto.setText("Depósito realizado com sucesso! Saldo atual: " + conta.getSaldo());
                    botao.setEnabled(false);
                    botao.setVisible(false);
                }catch(NumberFormatException ex){
                    texto.setText("Favor, digitar um número válido");
                }catch(IllegalArgumentException ex){
                    texto.setText(ex.getMessage());
                }
            });
            
        });
    }
}
