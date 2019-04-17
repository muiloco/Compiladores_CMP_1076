
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class MaquinaVirtual {
    ArrayList<String> opAritLog = new ArrayList<>(Arrays.asList("add","sub",
            "mul","div","mod","pot","and","or","xor","not"));
    ArrayList<String> opDesv = new ArrayList<>(Arrays.asList("jump", "jeq",
            "jne", "jlt", "jle", "jgt", "jge"));
    ArrayList<String> opMovDados = new ArrayList<>(Arrays.asList("load", "store",
            "move", "push", "pop"));
    ArrayList<String> opES = new ArrayList<>(Arrays.asList("read", "write"));
    
    HashMap registrador;
    int[] memoriaDados;
    String[] memoriaInstrucoes;
    String instrucaoAtual;
    Stack<Integer> pilha;
    int pc;
    int flag;
    
    public boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public MaquinaVirtual() {
        registrador = new HashMap<String,Integer>() {{
            put("r0", 0);
            put("r1", 0);
            put("r2", 0);
            put("r3", 0);
            put("r4", 0);
            put("r5", 0);
            put("r6", 0);
            put("r7", 0);
            put("r8", 0);
            put("r9", 0);
        }};
        
        memoriaDados = new int[1024];
        memoriaInstrucoes = new String[1024];
        pilha = new Stack();
        pc = 0;
        flag = 0;
    }
    
    public void buscarInstrucao() {
        instrucaoAtual = memoriaInstrucoes[pc];
        pc++;
    }
    
    public void decodificarInstrucao() {
        StringTokenizer lexer = new StringTokenizer(instrucaoAtual);
        if (lexer.countTokens() <= 4) {
            String opcode = lexer.nextToken();
            if (opAritLog.contains(opcode)) {
                try {
                    String regDst = lexer.nextToken();
                    if (! registrador.containsKey(regDst)) {
                        System.out.println("ERRO! Registrador de destino inválido");
                    }
                    String regOp1 = lexer.nextToken();
                    if (! registrador.containsKey(regOp1)) {
                        System.out.println("ERRO! Primeiro operando (reg) inválido");
                    }
                    String regOp2 = lexer.nextToken();
                    if (!registrador.containsKey(regOp2) || !isNumber(regOp2)) {
                        System.out.println("ERRO! Segundo operando (reg) inválido");
                    }

                System.out.println("Operador aritmético: " + opcode);
                System.out.println("Reg. Destino: " + regDst);
                System.out.println("Reg. Operando 1: " + regOp1);
                System.out.println("Reg. Operando 2: " + regOp2);

                opAritLog(opcode, regDst, regOp1, regOp2);

                } catch (Exception e) {
                    System.out.println("Comando inválido!");
                }


            }
            else if (opDesv.contains(opcode)) {
                System.out.println("Operador de desvio");

            }
            else if (opMovDados.contains(opcode)) {
                System.out.println("Operador de Movimentação de dados");
            }
            else if (opES.contains (opcode)) {
                System.out.println("Operador de Entrada/Saída");
            }
            else {
                System.out.println("ERRO! Opcode inválido!");
            }
        } else {
            System.out.println("ERRO! Quantidade de tokens incorreta!");
        }
    }
    
    public void opAritLog(String opcode, String regDst, String regOp1, String regOp2) {
        if (opcode.equals("add")) {
            if (registrador.containsKey(regOp2)) {
                int resultado = (int)registrador.get(regOp1) + (int)registrador.get(regOp2);
                registrador.put(regDst, resultado);
            } else {
                int resultado = (int)registrador.get(regOp1) + Integer.parseInt(regOp2);
                registrador.put(regDst, resultado);
            }
        }
        
    }
    
    public static void main(String[] args) {
        String comando = new Scanner(System.in).nextLine();
        MaquinaVirtual mv = new MaquinaVirtual();
        mv.memoriaInstrucoes[0] = comando;
        mv.buscarInstrucao();
        mv.decodificarInstrucao();
        System.out.println("Registradores:");
        System.out.println("R0: " + mv.registrador.get("r0"));    
        System.out.println("R1: " + mv.registrador.get("r1"));    
        System.out.println("R2: " + mv.registrador.get("r2"));    
    }
}
