
# Processo

Pode ser entendido como a instancia de programa de que esta sendo executado no momento. o sistema operacional cria um processo para gerenciar a execução desse programa. o processo é uma tarefa que é dividida em threads 

# Threads

Thread é uma sequencia de instruçoes que fazem parte de um processo. 

<aside>
💡

O que melhor distingue uma thread de um processo é o espaço de endereçamento. Todas as threads de um processo trabalham no mesmo espaço de endereçamento, que é a memória lógica do “processo hospedeiro”. Isto é, quando se tem um conjunto de threads dentro de um processo, todas as threads ex ecutam o código do processo e compartilham as suas variáveis.

</aside>

# Paralelismo

De forma breve, é a execução simultanea de multiplas tarefas ou instruçoes

Para que o paralelismo seja possível, os computadores modernos possuem **múltiplos núcleos de processamento**. Cada núcleo pode executar uma tarefa independentemente, simulando a execução simultânea de várias instruções.

**Existem diferentes níveis de paralelismo:**

- **Paralelismo a nível de instrução:** O processador divide as instruções de um programa em partes menores e as executa simultaneamente.
- **Paralelismo a nível de thread:** Um processo pode ser dividido em várias threads, que são como mini-processos que compartilham a mesma memória. Cada thread pode ser executada em um núcleo diferente.
- **Paralelismo a nível de processo:** Múltiplos processos podem ser executados simultaneamente em diferentes núcleos ou até mesmo em diferentes computadores (paralelismo distribuído).

<aside>
💡

mas há um problema ao só implementar o paralelismo, como é ao mesmo tempo, disputam os recursos. causando gargalos 

</aside>

<aside>
💡

little`s law

</aside>

# Concorrencia

tem relação com fluxo de execuçao. em programas sequenciais existe somente um fluxo, mas já em um programa concorrente pode ter varios fluxos.

Estes, podem até ser executados ao mesmo tempo, mas disputada. 

<aside>
💡

Na programação, **concorrência é a composição de processos executando independentemente**, enquanto **paralelismo é a execução simultânea de computações possivelmente relacionadas**.

concorrencia é lidar com muitas tarefas ao mesmo tempo. e paralelismo é executar muitas tarefas ao mesmo tempo

</aside>

# Em java

https://github.com/EduardoHrq/LEARN-ThreadsJava

A JVM é responsavel por cuidar da pliha ou segmento 

Thread → é a classe principal, e participa da pilha de execução

thread → representa a tarefa a ser feita, atraves do Runnable que implementa o metodo run()

```java
public static void main(String[] args) {
	Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                
            }
        });
	thread1.start(); // iniciar a thread
	
	Thread thread2 = new Thread(new ClassWithRunnable());
	thread2.start();
	
	new Thread() {
		@override
		public void run() { 
			System.out.println("thread3");
		}
	}.start();
}

class ClassWithRunnable implements Runnable {
	@override 
	public void run() {
		System.out.println("ok")
	}
}

```

- precisa ser o `.start()` , pois irá criar uma nova thread. o metodo `.run()` somente executará o metodo run da Runnable na thread atual

## Estados de uma thread

<aside>
💡

uma vez usado o start, não é possivel usar o start denovo sem ser finalizado 

</aside>

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/c0ee54e5-bba5-48b7-bb21-0191ed57979c/ce33596e-4290-4e06-90bc-f43ee818a553/image.png)

- NEW - ela foi criada e está pronta para iniciar (`start()`)
- RUNNABLE - ela está rodando (não existe o estado `RUNNING`)
- BLOCKED - ela está travada, em geral por `Lock` ou alguma operação de IO
- WAITING - ela está aguardando outra *thread* para rodar
- TIMED_WAITING - a mesma coisa, mas há um limite de tempo que ela esperará
- TERMINATED - ela terminou a execução, mas ainda existe (não existe o estado `DEAD`)

### Synchronized

Um thread deve esperar um outro Thread terminar de executar o metodo chamado por ambas. 

→ um Thread por vez

```java
public void example() {
	synchronized (this) {
		// bloco
	}
}

public synchronized void example2() {
	// bloco
}
```

## wait | notify | notifyAll

`wait()`

- para o thread por tempo inderminado
- so volta a sua execução apos usar `notify()`

<aside>
💡

Diferença entre wait e sleep

→ wait → para por tempo indeterminado e só volta com o uso de notify

→ sleep → para por tempo determinado e volta sozinho a sua execução

</aside>

`notify()` e `notifyAll()`

- irão acordar as threads que estão em wait
- notify
    - apenas a ultima ou que esta no topo da pilha
- notifyAll
    - notifica todas as threads

### Volatile

usará o valor mais atual, ouvindo mudanças em determinado atributo.

## threadpool

## executors

## Structured concurrency

## virtual Threads

https://www.inf.unioeste.br/~jorge/COMPILADORES/COMPILADORES/ANO%202011/ARTIGOS%20e%20LINKS%20INTERESSANTES/ARTIGOS/Programa%E7%E3o%20Concorrente%20-%20Introdu%E7%E3o.pdf

https://docs.oracle.com/javase/tutorial/essential/concurrency/highlevel.html

https://www.youtube.com/watch?v=HQh0Omi7k7s&list=PLuYctAHjg89YNXAXhgUt6ogMyPphlTVQG&index=4

https://www.youtube.com/watch?v=Z8ykx7ze_Co