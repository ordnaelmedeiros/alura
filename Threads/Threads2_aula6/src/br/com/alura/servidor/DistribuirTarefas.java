package br.com.alura.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	private ServidorTarefas servidor; // novo atributo
	private ExecutorService threadPool;

	// recebendo servidor
	public DistribuirTarefas(ExecutorService threadPool, Socket socket, ServidorTarefas servidor) {
		this.threadPool = threadPool;
		this.socket = socket;
		this.servidor = servidor; // novo
	}

	@Override
	public void run() {

		try {
			System.out.println("Distribuindo as tarefas para o cliente " + socket);

			Scanner entradaCliente = new Scanner(socket.getInputStream());
			PrintStream saidaCliente = new PrintStream(socket.getOutputStream());

			while (entradaCliente.hasNextLine()) {

				String comando = entradaCliente.nextLine();
				System.out.println("Comando recebido " + comando);

				switch (comando) {
				case "c1": {
					saidaCliente.println("Confirmação do comando: " + comando);
					ComandoC1 c1 = new ComandoC1(saidaCliente); // criando comando
					this.threadPool.execute(c1);
					break;
				}
				case "c2": {
					saidaCliente.println("Confirmação do comando c2");

					// criando os dois comandos
					ComandoC2ChamaWs c2WS = new ComandoC2ChamaWs(saidaCliente);
					ComandoC2AcessaBanco c2Banco = new ComandoC2AcessaBanco(saidaCliente);

					// passando os comandos para o pool, resultado é um Future
					Future<String> futureWS = this.threadPool.submit(c2WS);
					Future<String> futureBanco = this.threadPool.submit(c2Banco);

					// novo, passando a tarefa para juntar os resultados para o pool
					this.threadPool.submit(new JuntaResultadosFutureWSFutureBanco(futureWS, futureBanco, saidaCliente));

					break;
				}
				case "fim": {
					saidaCliente.println("Desligando o servidor");
					servidor.parar();
					break;
				}
				default: {
					saidaCliente.println("Comando não encontrado");
				}
				}

				System.out.println(comando);
			}

			saidaCliente.close();
			entradaCliente.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}