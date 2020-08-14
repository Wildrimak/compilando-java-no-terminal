# Entendendo como o java compila

Cenário: Pasta chamada projeto-muito-simples, possui um arquivo Main.java, sem pacote, com um método main que retorna “Hello World!”

* Execução no terminal, dentro de projeto-muito-simples
  * ```java Main.java``` -> printa “Hello World!”

* Compilação no terminal, dentro de projeto-muito-simples
  * ```javac Main.java```  -> gera Main.class

* Executando classe compilada no mesmo diretório
  * ```java Main``` -> printa “Hello World!”

Cenário: Pasta chamada projeto-simples, possui duas pastas src e bin, em src temos uma pasta que representa o pacote, wildrimak, no qual dentro há uma classe de nome SimpleMain com definição de um pacote chamado wildrimak, com um método main que printa um “Hello World”.

* Execução no terminal, dentro de projeto-simples/src/wildrimak
  * ```java NomeClasse.java``` -> printa “Hello World”
* Compilação no terminal, dentro de projeto-simples/src/wildrimak
  * ```javac NomeClasse.java```  -> gera NomeClasse.class

* Executando classe compilada no mesmo diretório
  * ```java -cp .. wildrimak.NomeClasse``` -> printa “Hello World”

* Compilação no terminal, especificando local de geração do .class, dentro de projeto-simples/src/wildrimak
  * ```javac -d ../../bin NomeClasse.java``` -> gerará projeto-simples/bin/wildrimak/NomeClasse.class
  * ```javac -d [path] NomeClasse.java``` -> forma generica do comando, gerará NomeClasse.class em [path]/[pacote]/NomeClasse.class

* Executando classe projeto-simples/src/wildrimak/NomeClasse.java cujo .class está em projeto-simples/bin/wildrimak/
  * ```java -cp ../../bin wildrimak.NomeClasse``` -> gera “Hello World”
  * ```java -cp [path] [pacote].NomeClasse``` -> caso genérico

Cenário: Pasta chamada projeto-composto, possui duas pastas src/main/java e bin/main/java, em src/main/java temos uma pasta que representa o pacote, br.com.wildrimak.app, no qual dentro há uma classe de nome ProjetoCompostoApplication tendo a definição de um pacote chamado br.com.wildrimak.app, com um método main que tem a criação de um objeto hello e a criação de um objeto world, ambas chamados no método main com hello.getHello() + world.getWorld(). Há também em br.com.wildrimak.app.models uma classe Hello com um método getHello() que retorna “Super hello “ e uma classe World com um método getWorld que retorna “world!!!”.

* Ao que tudo indica quando se tem arquivos compostos, só posso executar se eu compilar eles antes.

* Compilação no terminal, dentro de projeto-composto na pasta espelhada em projeto-composto/bin/main/java
  * ```javac -d bin/main/java/ src/main/java/br/com/wildrimak/app/ProjetoCompostoApplication.java src/main/java/br/com/wildrimak/app/models/*``` -> gerará os .class em projeto-composto/bin/main/java//wildrimak/br.com.wildrimak.app
  * ```javac -d [path] [caminho-até-main-do-projeto] [[caminhos-de-cada-pasta-dentro-da-main]...]``` -> forma genérica do comando, gerará os .class em [path]/[pacote]/ProjetoCompostoApplication.class e os demais pacotes de .class passados

* Executando classe projeto-composto/src/main/java/br/com/wildrimak/app/ProjetoCompostoApplication.java cujo .class está em projeto-composto/bin/main/java/wildrimak/
  * ```java -cp bin/main/java br/com/wildrimak/app/ProjetoCompostoApplication``` -> gera “Super hello world!!!”
  * ```java -cp [path] [pacote].ProjetoCompostoApplication``` -> caso genérico
