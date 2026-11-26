package Banco;

public class Pessoa {
        private String Titular, CPF;

        public Pessoa(String Titular, String CPF){
            this.Titular = Titular;
            this.CPF = CPF;
        }

        public String getTitular(){
            return this.Titular;
        } 

        public String getCPF(){
            return this.CPF;
        }

        public void setTitular(String Titular){
            this.Titular = Titular;
        }

        public void setCPF(String CPF){
            this.CPF = CPF;
        }
}
